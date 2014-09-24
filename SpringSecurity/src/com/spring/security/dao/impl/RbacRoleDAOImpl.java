package com.spring.security.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.spring.security.dao.RbacRoleDAO;
import com.spring.security.data.RbacPermission;
import com.spring.security.data.RbacRole;
import com.spring.security.data.RbacService;

public class RbacRoleDAOImpl extends JdbcDaoSupport implements RbacRoleDAO {

	// s1.SERVICE_TYPE as SERVICE_TYPE,

	private static final String roleQuery = "select r1.ROLE_ID as rbacRoleId, r1.ROLE_NAME as roleName, "
			+ "s1.SERVICE_ID as rbacServiceId, s1.SERVICE_NAME as serviceName, "
			+ "p1.PERMISSION_ID as rbacPermissionId, p1.SERVICE_ID as permServiceId,  p1.PERMISSION_NAME as permissionName "
			+ "FROM "
			+ "RBAC_ROLE r1 LEFT OUTER JOIN ROLE_PERMISSION rp1 ON rp1.ROLE_ID = r1.ROLE_ID "
			+ "LEFT OUTER JOIN RBAC_PERMISSION p1 ON p1.PERMISSION_ID = rp1.PERMISSION_ID "
			+ "LEFT OUTER JOIN RBAC_SERVICE s1 ON s1.SERVICE_ID = p1.SERVICE_ID "
			+ "LEFT OUTER JOIN USER_ROLE ur ON ur.ROLE_ID = r1.ROLE_ID "
			+ "WHERE ur.user_id= ? order by r1.ROLE_ID, s1.SERVICE_ID";

	@Override
	public List<RbacRole> fetchAllRoleByUserId(Long userId) {

		List<RbacRole> rbacRoleList = new ArrayList<RbacRole>();

		try {
			PreparedStatement ps = getJdbcTemplate().getDataSource()
					.getConnection().prepareStatement(roleQuery);
			ps.setLong(1, userId);

			ResultSet rs = ps.executeQuery();
			
			Map<Integer, RbacRole> rbacRoleMap = new HashMap<Integer, RbacRole>();
			Map<Integer, RbacService> rbacServiceMap = new HashMap<Integer, RbacService>();
			Map<Integer, RbacPermission> rbacPermissionMap = new HashMap<Integer, RbacPermission>();
			
			if(rs != null) {
				
				while(rs.next()) {
					
					RbacRole role = null;
					Integer roleId = rs.getInt("rbacRoleId");
					
					if(rbacRoleMap.get(roleId) == null) {
						role = new RbacRole();
						role.setRbacRoleId(rs.getInt("rbacRoleId"));
						role.setRoleName(rs.getString("roleName"));
						
						rbacRoleMap.put(roleId, role);
						rbacRoleList.add(role);
					}
					else {
						role = rbacRoleMap.get(roleId);
					}
					
					
					RbacService service = null;
					Integer rbacServiceId = rs.getInt("rbacServiceId");
					
					if(rbacServiceMap.get(rbacServiceId) == null) {
						service = new RbacService();
						service.setRbacServiceId(rs.getInt("rbacServiceId"));
						service.setServiceName(rs.getString("serviceName"));

						
						rbacServiceMap.put(rbacServiceId, service);
						role.addRbacService(service);
					}
					else {
						service =rbacServiceMap.get(rbacServiceId);
					}
					
					
					RbacPermission permission = null;
					Integer permissionId = rs.getInt("rbacPermissionId");
					
					if(rbacPermissionMap.get(permissionId) == null) {
						permission = new RbacPermission();
						permission.setRbacPermissionId(rs.getInt("rbacPermissionId"));
						permission.setRbacServiceId(rs.getInt("permServiceId"));
						permission.setPermissionName(rs.getString("permissionName"));
						
						rbacPermissionMap.put(permissionId, permission);
						service.addRbacPermission(permission);
					}
					
					
					//service.addRbacPermission(permission);
				}
				
				rs.close();
			}
			
			rbacRoleMap.clear();
			rbacServiceMap.clear();
			rbacPermissionMap.clear();

		} catch (SQLException exc) {
			exc.printStackTrace();
		}

		return rbacRoleList;
	}

}
