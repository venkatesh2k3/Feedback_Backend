package com.feedback.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.feedback.pojo.LoginPojo;

@Service
public class FeedbackService {
	@Autowired
	JdbcTemplate jtemplate;
	
	public int adduser(LoginPojo lp) {
		String Rollnumber=lp.getRollNumber();
		String Name=lp.getName();
		String Year=lp.getYear();
		String Semester=lp.getSemester();
		String Branch=lp.getBranch();
		String Address=lp.getAddress();
		String Gender=lp.getGender();
		String Phonenumber=lp.getPhoneNumber();
		String Email=lp.getEmail();
		String Password=lp.getPassword();
		String query = "insert into Logintable(Rollnumber,Name,Year,Semester,Branch,Address,Gender,Phonenumber,Email,Password)  values(?,?,?,?,?,?,?,?,?,?)";
		int i = jtemplate.update(query,Rollnumber,Name,Year,Semester,Branch,Address,Gender,Phonenumber,Email,Password);
		return i;
	}
	
	public List<Map<String,Object>> select() {
		String query = "select * from Logintable;";
		List<Map<String,Object>> list = new ArrayList<>();
		list =jtemplate.queryForList(query);
		return list;
	}
}
