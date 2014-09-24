package com.spring.security.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.security.dao.RbacRoleDAO;
import com.spring.security.data.AppUser;
import com.spring.security.data.RbacPermission;
import com.spring.security.data.RbacRole;
import com.spring.security.data.RbacService;

public class CustomJdbcDAOImpl extends JdbcDaoSupport implements
		UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RbacRoleDAO rbacRoleDAO;

	private String usersByUsernameQuery;

	public String getUsersByUsernameQuery() {
		return usersByUsernameQuery;
	}

	public void setUsersByUsernameQuery(String usersByUsernameQuery) {
		this.usersByUsernameQuery = usersByUsernameQuery;
	}

	public void changePassword(String username, String password) {
		UserDetails user = loadUserByUsername(username);

		String encodedPassword = passwordEncoder.encodePassword(password, user);
		getJdbcTemplate().update(
				"UPDATE USERS SET PASSWORD = ? WHERE USERNAME = ?",
				encodedPassword, username);
	}

	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		List<UserDetails> userDetailList = getJdbcTemplate().query (usersByUsernameQuery, new String[] { username },
				new RowMapper<UserDetails>() {

					public UserDetails mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						String username = rs.getString("username");
						String password = rs.getString("password");

						List<GrantedAuthority> authorizeList = fetchUserAuthority(rs
								.getLong("id"));

						AppUser user = null;
						if (authorizeList != null && authorizeList.size() > 0) {
							user = new AppUser(username, password, true, true,
									true, true, authorizeList);
						} else {
							user = new AppUser(username, password, true, true,
									true, true, AuthorityUtils.NO_AUTHORITIES);
						}

						user.setId(rs.getLong("id"));
						user.setPassword(password);
						user.setSalt(rs.getString("SALT"));

						return user;
					}
				});

		if(userDetailList != null && userDetailList.size() > 0 ) {
			return userDetailList.get(0);
		}
		return null;
	}

	private List<GrantedAuthority> fetchUserAuthority(Long userId) {

		Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();

		List<GrantedAuthority> dbAuthorizeList = new ArrayList<GrantedAuthority>(
				dbAuthsSet);
		loadUserPermission(dbAuthorizeList, userId);

		return dbAuthorizeList;
	}

	private void loadUserPermission(List<GrantedAuthority> dbAuths, Long userId) {

		if (userId != null) {
			List<RbacRole> roleList = rbacRoleDAO.fetchAllRoleByUserId(userId);
			StringBuilder permissionName = new StringBuilder();

			if (roleList != null) {
				for (RbacRole rbacRole : roleList) {

					if ("SUPER_ADMINISTRATOR".equals(rbacRole.getRoleName())) {
						dbAuths.add(new SimpleGrantedAuthority(rbacRole
								.getRoleName()));
					} else if ("ADMINISTRATOR".equals(rbacRole.getRoleName())) {
						dbAuths.add(new SimpleGrantedAuthority(rbacRole
								.getRoleName()));
					} else {
						List<RbacService> serviceList = rbacRole.getServiceList();

						if (serviceList != null) {
							for (RbacService rbacService : serviceList) {

								String serviceName = rbacService.getServiceName().toUpperCase();
								dbAuths.add(new SimpleGrantedAuthority(serviceName));

								List<RbacPermission> permissionList = rbacService
										.getPermissionList();

								if (permissionList != null) {
									for (RbacPermission rbacPermission : permissionList) {
										permissionName
												.append(serviceName)
												.append("_")
												.append(rbacPermission
														.getPermissionName()
														.toUpperCase());
										dbAuths.add(new SimpleGrantedAuthority(
												permissionName.toString()));
										permissionName.delete(0,
												permissionName.length());
									}
								}
							}

						} // end of serviceList null check
					}

				}
			} // end of roleList null check

			dbAuths.add(new SimpleGrantedAuthority("ROLE_ACCESS"));
		}
	}

}
