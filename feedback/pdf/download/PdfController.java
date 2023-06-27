
package com.feedback.pdf.download;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;
@RestController
@RequestMapping("/pdf")
public class PdfController {

   @GetMapping("/export")
   public ResponseEntity<byte[]> exportToPdf(HttpServletResponse response, @RequestParam String Roll) throws SQLException, IOException, DocumentException {
    //   String query = "SELECT * FROM feedback where RollNumber=?";
  //  System.out.println(Roll);

       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "M1racle@123");
   
    PreparedStatement ps=conn.prepareStatement("SELECT * FROM Student where RollNumber='"+Roll+"'");
    ResultSet resultSet=ps.executeQuery();
           Document document = new Document();
           ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
           PdfWriter.getInstance(document, outputStream);
           document.open();
           while (resultSet.next()) {
               String rollNumber = resultSet.getString("rollNumber");
               String knowledge_of_subject = resultSet.getString("knowledge_of_subject");
               String coming_well_for_class = resultSet.getString("	coming_well_for_class");
               String  giving_clear_explanations= resultSet.getString("giving_clear_explanations");
               String command_of_language = resultSet.getString("command_of_language");
               String clear_and_audible_voice = resultSet.getString("clear_and_audible_voice");
               
               String holding_attention_of_students = resultSet.getString("holding_attention_of_students");
               String providing_more_matter = resultSet.getString("providing_more_matter");
               String clear_the_doubts	 = resultSet.getString("clear_the_doubts	");
               String encouraging_students = resultSet.getString("encouraging_students");
               
               String appreciating_students = resultSet.getString("appreciating_students");
               String willingness_to_help_students = resultSet.getString("willingness_to_help_students");
               String return_of_test_papers = resultSet.getString("return_of_test_papers");
               String punctuality_following_timetable = resultSet.getString("punctuality_following_timetable");
               String coverage_of_syllabus = resultSet.getString("coverage_of_syllabus");
               String impartial = resultSet.getString("impartial");
               
               String department = resultSet.getString("department");
               String hod_name = resultSet.getString("hod_name");
               String faculty_name	= resultSet.getString("faculty_name");
               String subject_name = resultSet.getString("subject_name");
               String year = resultSet.getString("year");
               String semester = resultSet.getString("semester");
               String acadamic_year = resultSet.getString("acadamic_year");
               
               
               
               this.addStudentInfoToPdf(document, rollNumber, knowledge_of_subject, coming_well_for_class, giving_clear_explanations, command_of_language, clear_and_audible_voice, holding_attention_of_students, providing_more_matter, clear_the_doubts, encouraging_students,appreciating_students
            		   ,willingness_to_help_students,return_of_test_papers,punctuality_following_timetable,coverage_of_syllabus,impartial,department,hod_name,
            		   faculty_name,subject_name,year,semester,acadamic_year);
               document.newPage();
           }

           document.close();
           HttpHeaders headers = new HttpHeaders();
           headers.setContentType(MediaType.APPLICATION_PDF);
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
           String fileName = "StudentFeedBack_" + dateFormat.format(new Date()) + ".pdf";
           
           headers.setContentDispositionFormData("attachment", fileName);
               
           return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
       }
   private void addStudentInfoToPdf(Document document, String RollNumber, String knowledgeOfSubject, String comingWellForClass, String givingClearExplanations, String commandOfLanguage,
                String clearAndAudibleVoice, String holdingAttentionOfStudents, String providingMoreMatter, String clearTheDoubts, String encouragingStudents,
                String appreciatingStudents,String willingnessToHelpStudents,String returnOfTestPapers,String punctualityFollowingTimetable,String coverageOfSyllabus,
                String Impartial,String Department,String hodName,String facultyName,String subjectName,String Year,String Semester,String acadamicYear) throws DocumentException {
    Paragraph paragraph = new Paragraph();
    paragraph.add(new Paragraph("RollNumber :" + RollNumber));
    paragraph.add(new Paragraph("knowledgeOfSubject : " + knowledgeOfSubject));
paragraph.add(new Paragraph("comingWellForClass :" + comingWellForClass));
paragraph.add(new Paragraph("givingClearExplanations : " + givingClearExplanations));
paragraph.add(new Paragraph("commandOfLanguage : " + commandOfLanguage));
paragraph.add(new Paragraph("clearAndAudibleVoice : " + clearAndAudibleVoice));
paragraph.add(new Paragraph("holdingAttentionOfStudents : " + holdingAttentionOfStudents));
paragraph.add(new Paragraph("providingMoreMatter : " + providingMoreMatter));
paragraph.add(new Paragraph("clearTheDoubts : " + clearTheDoubts));
paragraph.add(new Paragraph("encouragingStudents : " + encouragingStudents));
paragraph.add(new Paragraph("appreciatingStudents : " + appreciatingStudents));

paragraph.add(new Paragraph("willingnessToHelpStudents : " + willingnessToHelpStudents));
paragraph.add(new Paragraph("returnOfTestPapers : " + returnOfTestPapers));

paragraph.add(new Paragraph("punctualityFollowingTimetable : " + punctualityFollowingTimetable));
paragraph.add(new Paragraph("coverageOfSyllabus : " + coverageOfSyllabus));
paragraph.add(new Paragraph("Impartial : " + Impartial));
paragraph.add(new Paragraph("Department : " + Department));

paragraph.add(new Paragraph("hodName : " + hodName));
paragraph.add(new Paragraph("facultyName : " + facultyName));
paragraph.add(new Paragraph("subjectName : " + subjectName));

paragraph.add(new Paragraph("Year : " + Year));
paragraph.add(new Paragraph("Semester : " + Semester));
paragraph.add(new Paragraph("acadamicYear : " + acadamicYear));







document.add(paragraph);
    }
   }



	
