package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController 
{
	@Autowired
	private StudentService service;//interface
	
	@GetMapping("/")
	public String home()
	{
		return "Rest API with JPA";
	}
	
	@PostMapping("add")
	public String addstudent(@RequestBody Student s)
	{
		
		return service.addStudent(s);
	}
	
	@GetMapping("viewall")
	public List<Student> viewallstudents()
	{
		return service.displayallStudents();
	}
	
	//Models
	//Repost
	//Service a Imple
	//'
	
	@GetMapping("display")
	public Student displayStudentByID(@RequestParam("id") int sid)
	{
		return service.displayStudentByID(sid);
	}
	
	
	@DeleteMapping("delete")
	public String deleteStudent(@RequestParam("id") int sid)
	{
		return service.deleteStudent(sid);
	}
	
	//@RequestBody is considered as a indication for giving object as input
	
	@PutMapping("update")
	public String updateStudent(@RequestBody Student s)
	{
		return service.updateStudent(s);
	}
}
