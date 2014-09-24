package com.mfeast.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mfeast.service.MFeastAppService;
import com.mfeastapp.model.ContactDetail;
import com.mfeastapp.model.Survey;
import com.mfeastapp.model.UserTable;
import com.sample.FeastType;

@Controller
public class MainController {
	
	@Autowired
	MFeastAppService service;

	@RequestMapping("/")
	public String returnAfterLogin() {
		return "index";
	}

	@RequestMapping("/home")
	public ModelAndView showLogin(@ModelAttribute("login") @Valid UserTable user,
			BindingResult result, HttpSession session) {
		ModelAndView modelAndView = null;
		System.out.println(user.getUserName());
		if (result.hasErrors()) {
			modelAndView=new ModelAndView("index");
		}
//		MFeastAppService service = ApplicationContextProvider
//				.getApplicationContext().getBean(MFeastAppService.class);
		UserTable userDetails = service.validateUser(user.getUserName(),
				user.getPassword());
		if (userDetails == null) {
			modelAndView = new ModelAndView("index");
		} else {
			session.setAttribute("validatedUser", userDetails);
			if (userDetails.getUserRole().getRoleName()
					.equalsIgnoreCase("admin")) {
				modelAndView = new ModelAndView("admin");

			} else if (userDetails.getUserRole().getRoleName()
					.equalsIgnoreCase("user")) {
				modelAndView = new ModelAndView("user");
			}

		}
		return modelAndView;
	}

	@RequestMapping("/submitSurvey")
	public String getFormFeast(@ModelAttribute("surveyDetails") Survey survey,
			BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			System.out.println("errors in feast poll");
		}
		survey.setType(FeastType.FeastPoll);
		UserTable user = (UserTable) session.getAttribute("validatedUser");
		// ContactDetail contactDetail=(ContactDetail)
		// session.getAttribute("validatedUser");
		survey.setCreatedDate(new Date());
//		MFeastAppService service = ApplicationContextProvider
//				.getApplicationContext().getBean(MFeastAppService.class);
		survey = service.addUserId(user.getUserId(), survey);
		session.setAttribute("survey", survey);
		// service.saveSurvey(survey);
		return "admin";

	}

	@RequestMapping("/submitSurveyFeed")
	public String getFormFedback(
			@ModelAttribute("surveyDetailsFeed") Survey survey,
			BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			System.out.println("errors in feedback");
		}
		survey.setCreatedDate(new Date());
		UserTable user = (UserTable) session.getAttribute("validatedUser");
		survey.setType(FeastType.Feedback);
//		MFeastAppService service = ApplicationContextProvider
//				.getApplicationContext().getBean(MFeastAppService.class);
		survey = service.addUserId(user.getUserId(), survey);
		session.setAttribute("survey", survey);
		// service.saveSurvey(survey);
		return "admin";
	}

	@RequestMapping("/getadminProfile")
	public ModelAndView getadminInformation(Map<String, Object> map,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("adminprofile");
		modelAndView.addObject("contactDetail", new ContactDetail());
//		MFeastAppService service = ApplicationContextProvider
//				.getApplicationContext().getBean(MFeastAppService.class);
		UserTable user = (UserTable) session.getAttribute("validatedUser");
		System.out.println(user.getUserId());
		ContactDetail validatedUserContactDetail = service
				.getContactByUserId(user);
		session.setAttribute("validatedUserContactDetail",
				validatedUserContactDetail);
		return modelAndView;
	}

	@RequestMapping("/getuserProfile")
	public ModelAndView getUserInformation(Map<String, Object> map,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("userprofile");
		modelAndView.addObject("contactDetail", new ContactDetail());
//		MFeastAppService service = ApplicationContextProvider
//				.getApplicationContext().getBean(MFeastAppService.class);
		UserTable user = (UserTable) session.getAttribute("validatedUser");
		System.out.println(user.getUserId());
		ContactDetail validatedUserContactDetail = service
				.getContactByUserId(user);
		session.setAttribute("validatedUserContactDetail",
				validatedUserContactDetail);
		return modelAndView;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String uploadFile(
			
			@RequestParam("mobileNumber") long mobileNumber,
			@RequestParam("permenantAddress") String permenantAddress,
			@RequestParam("temporaryAddress") String temporaryAddress,
			@RequestParam("displayPic") MultipartFile[] displayPic,
			HttpSession session) {
//		MFeastAppService service = ApplicationContextProvider
//				.getApplicationContext().getBean(MFeastAppService.class);
		MultipartFile file = displayPic[0];
		byte[] bytes = null;
		try {
			bytes = file.getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ContactDetail contactDetail = (ContactDetail) session
				.getAttribute("validatedUserContactDetail");
		contactDetail.setMobileNumber(mobileNumber);
		contactDetail.setPermenantAddress(permenantAddress);
		contactDetail.setTemporaryAddress(temporaryAddress);
		UserTable user = (UserTable) session.getAttribute("validatedUser");
		contactDetail.setUserId(user);
		Blob blob = null;
		try {
			blob = new SerialBlob(bytes);
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		contactDetail.setDisplayPic(blob);
		service.updateUserDetails(user.getUserId(), contactDetail);
		if (user.getUserRole().getRoleName().equalsIgnoreCase("ADMIN"))
			return "admin";
		else {
			return "user";
		}
	}

	@RequestMapping("/cancelEdit")
	public String cancelEdit(HttpSession session) {
		UserTable user = (UserTable) session.getAttribute("validatedUser");
		if (user.getUserRole().getRoleName().equalsIgnoreCase("admin")) {
			return "admin";
		} else {
			return "user";
		}

	}

	@RequestMapping(value = "/showimg/{id}", method = RequestMethod.GET)
	public void showimg(@PathVariable("id") Integer id,
			HttpServletResponse response, HttpServletRequest request,
			HttpSession session) throws SQLException, IOException {
		
		UserTable user = (UserTable) session.getAttribute("validatedUser");
		
//		MFeastAppService service = ApplicationContextProvider
//				.getApplicationContext().getBean(MFeastAppService.class);
		ContactDetail contactDetail = (ContactDetail) session
				.getAttribute("validatedUserContactDetail");

		
		ContactDetail blob = service.getDisplayPic(user);

		if (blob != null && blob.getDisplayPic() != null) {
			byte[] bytes = blob.getDisplayPic().getBytes((long) 1,
					(int) blob.getDisplayPic().length());

			response.setContentType("image/png");
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(bytes);
		}
	}
	
	@RequestMapping(value="/newPassword",method=RequestMethod.POST)
	public String changePassword(@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword")
	String newPassword,HttpSession session){
		UserTable user=(UserTable) session.getAttribute("validatedUser");
		if(oldPassword.equals(user.getPassword())){
			System.out.println(newPassword);
			user=service.updatePassword(user.getUserId(),newPassword);
		}
		session.setAttribute("validatedUser", user);
		if(user.getUserRole().getRoleName().equalsIgnoreCase("admin")){
			return "admin";
		}
		else{
			return "user";
		}
		
	}
	

	
	
	@RequestMapping("/changePassword")
	public String goToPasswordChangeScreen(HttpSession session){
		UserTable user=(UserTable) session.getAttribute("validatedUser");
		if(user.getUserRole().getRoleName().equalsIgnoreCase("admin")){
			return "changepasswordadmin";
		}
		else{
			return "changepassworduser";
		}
	}
	@RequestMapping("/cancelPassword")
	public String cancelThePassword(HttpSession session){
		UserTable user=(UserTable) session.getAttribute("validatedUser");
		if(user.getUserRole().getRoleName().equalsIgnoreCase("admin")){
			return "admin";
		}
		else{
			return "user";
		}
	}
	
	@RequestMapping("/calendarDisplay")
	String displayCalendar(HttpSession session){
		return "calendar";
	}
	
	@RequestMapping("/homePage")
	String backToHomePage(HttpSession session){
		return "admin";
	}
	
	@RequestMapping("/showProfile")
	String showprofile(HttpSession session){
		UserTable user=(UserTable) session.getAttribute("validatedUser");
		ContactDetail contactDetail = (ContactDetail) session
				.getAttribute("validatedUserContactDetail");
		if(user.getUserRole().getRoleName().equalsIgnoreCase("admin")){
			return "showadminprofile";
		}
		else{
			return "showuserprofile";
		}
	}
	
	@RequestMapping("surveyDetail")
	String showsurveydetail(HttpSession session,Map<String,Object> model){
		List<Survey> surveyDetails=service.getsurveydetails();
		model.put("surveyDetails", surveyDetails);
		return "surveyhistory";
	}
	
	@RequestMapping("/logout")
	public String logoutOfApp(HttpSession session) {
		session.removeAttribute("validateduser");
		session.removeAttribute("validatedUserContactDetail");
		session.invalidate();
		return "index";
		
	}
	
	

}
