package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired //it is used to communicate between two beans
	private StudentRepository repository;
	
	@Override
	public String addStudent(Student s) {
		repository.save(s);
		return "Student Added Successfully";
	}

	@Override
	public String updateStudent(Student s) {
		Optional<Student> obj =  repository.findById(s.getId());
		String msg = null;
		if(obj.isPresent())
		{
			Student student = obj.get();
			student.setAge(s.getAge());
			student.setContact(s.getContact());
			student.setDepartment(s.getDepartment());
			student.setEmail(s.getEmail());
			student.setName(s.getName());
			student.setGender(s.getGender());
			repository.save(student);
			msg = "Student Updated Successfully";
		}
		else {
			msg = "Student ID Not Found";
		}
		return msg;
	}

	@Override
	public String deleteStudent(int sid) {
	 Optional<Student> obj =  repository.findById(sid);
	 String msg = null;
	 if(obj.isPresent())
	 {
		 Student s = obj.get();
		 repository.delete(s);
		 msg = "Student Deleted Successfully";
	 }
	 else
	 {
		 msg = "Student ID Not Found";
	 }
	 
	 return msg;
		
	}

	@Override
	public Student displayStudentByID(int sid) {
		 return repository.findById(sid).get();
		
	}

	@Override
	public List<Student> displayallStudents() {
		return (List<Student>) repository.findAll();
	}

}
