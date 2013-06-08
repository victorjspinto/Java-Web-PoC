package br.com.viktor.javawebpoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.service.contract.StudentServiceContract;

@Controller
public class StudentController {

	private StudentServiceContract service;
	
	@Autowired
	public StudentController(StudentServiceContract service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET )
	@ResponseBody
	public List<Student> list(){
		return service.list();
	}

}
