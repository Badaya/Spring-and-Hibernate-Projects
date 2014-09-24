package com.spring.security.data;

import java.util.ArrayList;
import java.util.List;

public class RbacService {

	private Integer rbacServiceId;

	private String serviceName;

//	private ServiceTypeEnum type;

	private List<RbacPermission> permissionList;

	public Integer getRbacServiceId() {
		return rbacServiceId;
	}

	public void setRbacServiceId(Integer rbacServiceId) {
		this.rbacServiceId = rbacServiceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

//	public ServiceTypeEnum getType() {
//		return type;
//	}
//
//	public void setType(ServiceTypeEnum type) {
//		this.type = type;
//	}

	public List<RbacPermission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<RbacPermission> permissionList) {
		this.permissionList = permissionList;
	}

	public void addRbacPermission(RbacPermission permission) {
		if(this.permissionList == null) {
			permissionList = new ArrayList<RbacPermission>();
		}
		
		permissionList.add(permission);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RbacService [rbacServiceId=");
		builder.append(rbacServiceId);
		builder.append(", serviceName=");
		builder.append(serviceName);
		builder.append(", serviceType=");
		//builder.append(type != null ? type.getServiceType() : "null");

		if(permissionList != null) {
			builder.append(", permissionList=[ ");
			for (RbacPermission permission : permissionList) {
				builder.append(permission).append(", ");
            }
			builder.append("]  ");
		}

		builder.append("]");
		return builder.toString();
	}

}
