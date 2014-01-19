package br.com.viktor.javawebpoc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.viktor.javawebpoc.controller.base.AbstractCrudController;
import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.facade.StudentFacade;
import br.com.viktor.javawebpoc.l10n.MessageKey;
import br.com.viktor.javawebpoc.validation.StudentValidator;

@Controller
@RequestMapping("/student")
public class StudentController extends AbstractCrudController<Student>  {
	
	@Inject
	public StudentController(StudentFacade facade, StudentValidator validator) {
		super(facade, validator, MessageKey.ENTITY_STUDENT);
	}

}