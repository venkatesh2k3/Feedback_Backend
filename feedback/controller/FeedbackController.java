package com.feedback.controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.pojo.LoginPojo;
import com.feedback.service.FeedbackService;

@RestController
public class FeedbackController {
	@Autowired
	public FeedbackService fs;
	
	@PostMapping("/adddata")
	public String adduser(@RequestBody LoginPojo lp)
	{
		int i=fs.adduser(lp);
		if (i > 0) {
			return "Data Inserted";
		} else {
			return "Data not inserted";
		}
	}
	
	@GetMapping("/showdata")
	public List<Map<String,Object>> getAll() {
		return fs.select();
	}
	
	
}
