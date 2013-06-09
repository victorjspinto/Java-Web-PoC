package br.com.viktor.javawebpoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.service.contract.EntityNotExistException;
import br.com.viktor.javawebpoc.service.contract.StudentServiceContract;

@Controller
@RequestMapping("/student/*")
public class StudentController {

	private StudentServiceContract service;
	
	@Autowired
	public StudentController(StudentServiceContract service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET )
	@ResponseBody
	public List<Student> list(){
		return service.list();
	}
	
	@RequestMapping(value = "/find/{studentId}")
	@ResponseBody
	public String find(@PathVariable("studentId") long studentId) {
		try {
			return service.find(studentId).getName();

		} catch (EntityNotExistException e) {
			return "Not found";
		}		
	}
	
	@RequestMapping(value = "/save")
		public void save(Model model){
		model.addAttribute("list", service.list());
	}

}
