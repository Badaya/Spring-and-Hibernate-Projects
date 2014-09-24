package com.spring.security.data;

public class RbacPermission {

	private Integer rbacPermissionId;

	private Integer rbacServiceId;

	private String permissionName;

	public Integer getRbacPermissionId() {
		return rbacPermissionId;
	}

	public void setRbacPermissionId(Integer rbacPermissionId) {
		this.rbacPermissionId = rbacPermissionId;
	}

	public Integer getRbacServiceId() {
		return rbacServiceId;
	}

	public void setRbacServiceId(Integer rbacServiceId) {
		this.rbacServiceId = rbacServiceId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RbacPermission [rbacPermissionId=");
		builder.append(rbacPermissionId);
		builder.append(", permissionName=");
		builder.append(permissionName);
		
		builder.append(", rbacServiceId=");
		builder.append(rbacServiceId);
		
		builder.append("]");
		return builder.toString();
	}

}
