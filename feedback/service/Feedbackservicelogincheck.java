package com.feedback.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.feedback.pojo.Logincheckpojo;

@Service
public class Feedbackservicelogincheck {
	
	@Autowired
	JdbcTemplate jtemplate;

	public int resetpassword(Logincheckpojo lcp)
	{
		String RollNumber=lcp.getRollNumber();
		String Password=lcp.getPassword();
		String NewPassword=lcp.getNewPassword();
		try
		{
		String query="select Password from Logintable where Rollnumber='"+RollNumber+"';";
		List<Map<String, Object>> pswdindb=jtemplate.queryForList(query);
		Map<String, Object> var = pswdindb.get(0);
		String pswd = (String) var.get("Password");
		if(Password.equals(pswd))
		{
			int i=jtemplate.update("update Logintable set Password='"+NewPassword+"' where Rollnumber='"+RollNumber+"';");
			if(i>0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		else
		{
			return 2;
		}
		}
		catch(Exception e)
		{
			return 3;
		}
	}
	public int check(Logincheckpojo lcp)
	{
		String RollNumber=lcp.getRollNumber();
		String Password=lcp.getPassword();
		try
		{
		String query="select Password from Logintable where Rollnumber='"+RollNumber+"';";
		List<Map<String, Object>> pswdindb=jtemplate.queryForList(query);
		Map<String, Object> var = pswdindb.get(0);
		String pswd = (String) var.get("Password");
		if(Password.equals(pswd))
		{
			return 1;
		}
		else
		{
			return 0;
		}
		}
		catch(Exception e)
		{
			return 0;
		}
	}

}
