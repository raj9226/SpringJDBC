package com.raj.SpringJDBCEx;

import com.raj.SpringJDBCEx.Model.Students;
import com.raj.SpringJDBCEx.Service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext con =SpringApplication.run(SpringJdbcExApplication.class, args);
		StudentService ss = con.getBean(StudentService.class);
		Students s =con.getBean(Students.class);
		s.setRollNo(4);
		s.setName("Shikha");
		s.setMarks(100);
		ss.addStudent(s);
		List<Students> students = ss.getAllStudents();
		System.out.println(students);

	}

}
