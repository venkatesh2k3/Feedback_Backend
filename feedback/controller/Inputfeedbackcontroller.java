package com.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.pojo.Inputfeedbackpojo;
import com.feedback.service.Inputfeedbackservice;

@RestController
@CrossOrigin
public class Inputfeedbackcontroller {
	
	@Autowired
	Inputfeedbackservice fs;
	
	@PostMapping("insertFeedback")
	public String insert(@RequestBody Inputfeedbackpojo fb) {
		int i=fs.insertData(fb);
		
		if(i>0) {
			return "data inserted";
		}
		else {
			return "data not inserted";
		}		
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("fetchFeedback")
	public List getdata() {
		return fs.select();
	}
	
}