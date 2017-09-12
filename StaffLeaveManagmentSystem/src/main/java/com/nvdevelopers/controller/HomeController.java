package com.nvdevelopers.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nvdevelopers.service.ApplyLeaveService;
import com.nvdevelopers.service.FetchRecordsService;
import com.nvdevelopers.service.GrantLeaveService;
import com.nvdevelopers.service.LoginService;
import com.nvdevelopers.service.RegisterService;

/**
 * @author nalin
 *
 */
@Controller
public class HomeController {

	@Autowired
	LoginService LoginService;
	@Autowired
	RegisterService registerService;
	@Autowired
	FetchRecordsService fetchRecords;
	@Autowired
	ApplyLeaveService applyLeaveService;
	@Autowired
	GrantLeaveService grantLeaveService;

	@RequestMapping(value = "/")
	public String showHome() {
		return "Login";
	}

	@RequestMapping(value = "/Login")
	public String showLogin() {
		return "Login";
	}

	@RequestMapping(value = "/Register")
	public String showRegister() {
		return "Register";
	}

	@RequestMapping(value="/Login", method = RequestMethod.POST)
	public String hanldleLoginRequest(ModelMap model, @RequestParam String username, @RequestParam String password) 
	{
		if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin123")) {
			fetchRecords.showAdminRecord(username, password, model);
			model.put("username", username);
			return "Admin";
		}
		else if (username.equalsIgnoreCase("hod") && password.equalsIgnoreCase("hod123")) {
			fetchRecords.showHODRecord(username, password, model);
			model.put("username", username);
			return "Hod";
		}
		else if (!(LoginService.validateUser(username, password, model))) {
			model.put("errorMessage", "Invalid Credentials");
			return "Login";
		}
		model.put("username", username);
		return "ApplyLeave";
	}

	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public String showRegisterationMessage(ModelMap map, @RequestParam String name, @RequestParam String email,
			@RequestParam String username, @RequestParam String password, @RequestParam String contactno) {

		if (registerService.saveUser(name, email, username, password, contactno)) {
			return "SuccessAlert";
		} else {
			return "ErrorAlert";
		}
	}
	
	@RequestMapping(value="/Logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/ApplyLeave", method=RequestMethod.GET)
	public String showApplyLeave()
	{
		return "ApplyLeave";
	}
	
	@RequestMapping(value="/ApplyLeave", method=RequestMethod.POST)
	public String showLeaveApplicationMessage(@RequestParam String to, 
			@RequestParam String from, @RequestParam String reason)
	{
		if (applyLeaveService.applyLeave(to, from, reason)) {
			return "Success";
		}else {
			return "Error";
		}
	}
	
	@RequestMapping(value="/PermitLeave", method=RequestMethod.POST)
	public String grantLeaveApplication(@RequestParam int leaveid, @RequestParam int staffid,
			@RequestParam String to, @RequestParam String from) throws ParseException
	{
		if (!grantLeaveService.grantLeave(leaveid, staffid, to, from)) {
			return "Failed";
		}
		return "Granted";
	}
	
	@RequestMapping(value="/RejectLeave", method=RequestMethod.POST)
	public String rejectLeaveApplication(@RequestParam int leaveid)
	{
		grantLeaveService.rejectLeave(leaveid);
		return "Failed";
	}
	
	@RequestMapping(value="/Hod")
	public String showHOD()
	{
		return "Hod";
	}
}
