package com.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.pojo.Logincheckpojo;
import com.feedback.service.Feedbackservicelogincheck;


@RestController
public class Feedbackcontrollerlogincheck {

	@Autowired
	public Feedbackservicelogincheck fsl;
	
	@PostMapping("/resetpassword")
	public String resetpassword(@RequestBody Logincheckpojo lcp)
	{
		int i=fsl.resetpassword(lcp);
		if(i==1)
		{
			return "password updated";
		}
		else if(i==0)
		{
			return "password not updated";
		}
		else
		{
			return "wrong password";
		}
	}
//	
//	@PostMapping("/login1")
//	public Map adduser1(@RequestBody Logincheckpojo lcp)
//	{
//		
//	}
	
	@PostMapping("/login")
	public String adduser(@RequestBody Logincheckpojo lcp)
	{
		int i=fsl.check(lcp);
		if (i == 1) {
			return "Login success";
		} else {
			return "Invalid Credentials";
		}
	}
}
