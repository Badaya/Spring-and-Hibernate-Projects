package com.spring.security.data;

import java.util.ArrayList;
import java.util.List;

public class RbacRole {

	private Integer rbacRoleId;

	private String roleName;

//	private Integer enterpriseId;

//	private String enterpriseName;

	private List<RbacService> serviceList;

	public Integer getRbacRoleId() {
		return rbacRoleId;
	}

	public void setRbacRoleId(Integer rbacRoleId) {
		this.rbacRoleId = rbacRoleId;
	}

//	public String getEnterpriseName() {
//		return enterpriseName;
//	}
//
//	public void setEnterpriseName(String enterpriseName) {
//		this.enterpriseName = enterpriseName;
//	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

//	public Integer getEnterpriseId() {
//		return enterpriseId;
//	}
//
//	public void setEnterpriseId(Integer enterpriseId) {
//		this.enterpriseId = enterpriseId;
//	}

	public List<RbacService> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<RbacService> permissionList) {
		this.serviceList = permissionList;
	}

	public void addRbacService(RbacService service) {
		if(this.serviceList == null) {
			serviceList = new ArrayList<RbacService>();
		}
		
		serviceList.add(service);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RbacRole [rbacRoleId=");
		builder.append(rbacRoleId);
		builder.append(", roleName=");
		builder.append(roleName);
//		builder.append(", enterpriseId=");
//		builder.append(enterpriseId);

		if (serviceList != null) {
			builder.append(", serviceList=[ ");
			for (RbacService service : serviceList) {
				builder.append(service).append(", ");
			}
			builder.append("]  ");
		}
		builder.append("]");
		return builder.toString();
	}

}
