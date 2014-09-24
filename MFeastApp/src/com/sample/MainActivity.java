//package com.sample;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.mfeast.service.MFeastAppService;
//import com.mfeastapp.model.RoleTable;
//import com.mfeastapp.model.UserTable;
//
//public class MainActivity {
//	public static void main(String[] args) {
//		try {
//			ApplicationContext context = new ClassPathXmlApplicationContext("mfeast-daos.xml","mfeast-dao-infrastructure.xml");
//			RoleTable role=new RoleTable();
//			role.setRoleName("admin");
//			RoleTable role2=new RoleTable();
//			role2.setRoleName("user");
//			UserTable user = new UserTable();
//			user.setFirstName("Abhinav ");
//			user.setLastName("Piper");
//			user.setMiddleName("abcd");
//			user.setPassword("abhinav");
//			user.setSalt("abhinav");
//			user.setUserName("abhinav0419");
//			Set<RoleTable> roleset=new HashSet<RoleTable>();
//			UserTable user1 = new UserTable();
//			user1.setFirstName("Ravi ");
//			user1.setLastName("Nair");
//			user1.setMiddleName("abcd");
//			user1.setPassword("abhinav");
//			user1.setSalt("abhinav");
//			user1.setUserName("Ravi0419");
//			
//			roleset.add(role);
//			roleset.add(role2);
//			user.setRoleTable(role);
//			user1.setRoleTable(role2);
//			
//
//			MFeastAppService mFeastAppService = context
//					.getBean(MFeastAppService.class);
//			mFeastAppService.saveUserEntity(user);
//			mFeastAppService.saveUserEntity(user1);
//		} catch (Exception exc) {
//			exc.printStackTrace();
//		}
//	}
//
//}
