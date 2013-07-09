package br.com.viktor.javawebpoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.viktor.javawebpoc.controller.base.AbstractCrudController;
import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.service.contract.StudentServiceContract;

@Controller
@RequestMapping("/student")
public class StudentController extends AbstractCrudController<Student>  {

	@Autowired
	public StudentController(StudentServiceContract service) {
		super(service);
	}
	
}
