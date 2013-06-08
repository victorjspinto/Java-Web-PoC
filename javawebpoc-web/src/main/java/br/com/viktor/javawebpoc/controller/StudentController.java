package br.com.viktor.javawebpoc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.service.contract.StudentServiceContract;

@Controller
public class StudentController {

	private StudentServiceContract service;
	
	public StudentController(StudentServiceContract service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET )
	public List<Student> list(){
		return service.list();
	}

}
