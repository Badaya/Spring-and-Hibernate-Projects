package com.spring.security.data;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AppUser extends User {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String username;
	private String password;
	private String salt;

	public AppUser(String username, String password, boolean enabled,
	        boolean accountNonExpired, boolean credentialsNonExpired,
	        boolean accountNonLocked, List<GrantedAuthority> authorities) {

		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
		        accountNonLocked, authorities);
	}
	
	public AppUser(String username, String password, String salt, boolean enabled,
	        boolean accountNonExpired, boolean credentialsNonExpired,
	        boolean accountNonLocked, List<GrantedAuthority> authorities) {

		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
		        accountNonLocked, authorities);
		this.salt = salt;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
