package com.feedback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.feedback.pojo.Inputfeedbackpojo;

@Service
public class Inputfeedbackservice {
	
	@Autowired
	JdbcTemplate jt;
	
	public int insertData(Inputfeedbackpojo fb) {
		String knowledge_of_subject=fb.getKnowledge_of_subject();
		String coming_well_for_class=fb.getComing_well_for_class();
		String giving_clear_explanations=fb.getGiving_clear_explanations();
		String command_of_language=fb.getCommand_of_language();
		String clear_and_audible_voice=fb.getClear_and_audible_voice();
		String holding_attention_of_students=fb.getHolding_attention_of_students();
		String providing_more_matter=fb.getProviding_more_matter();
		String clear_the_doubts=fb.getClear_the_doubts();
		String encouraging_students=fb.getEncouraging_students();
		String appreciating_students=fb.getAppreciating_students();
		String willingness_to_help_students=fb.getWillingness_to_help_students();
		String return_of_testpapers=fb.getReturn_of_testpapers();
		String punctuality_following_timetable=fb.getPunctuality_following_timetable();
		String coverage_of_syllabus=fb.getCoverage_of_syllabus();
		String impartial=fb.getImpartial();
		String department=fb.getDepartment();
		String hod_name=fb.getHod_name();
		String faculty_name=fb.getFaculty_name();
		String subject_name=fb.getSubject_name();
		String year=fb.getYear();
		String semester=fb.getSemester();
		String acadamic_year=fb.getAcadamic_year();
		try {
		String sql="insert into feedback values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int i=jt.update(sql,knowledge_of_subject,coming_well_for_class,giving_clear_explanations,command_of_language,
				clear_and_audible_voice,holding_attention_of_students,providing_more_matter,clear_the_doubts,encouraging_students,
				appreciating_students,willingness_to_help_students,return_of_testpapers,punctuality_following_timetable,
				coverage_of_syllabus,impartial,department,hod_name,faculty_name,subject_name,year,semester,acadamic_year);
		
		return i;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
	
	public List<Map<String,Object>> select() {
		String query = "select * from feedback;";
		List<Map<String,Object>> list = new ArrayList<>();
		list =jt.queryForList(query);
		return list;
	
	}

}