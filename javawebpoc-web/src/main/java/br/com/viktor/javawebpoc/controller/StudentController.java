package br.com.viktor.javawebpoc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.viktor.javawebpoc.controller.base.AbstractCrudController;
import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.exception.invalidArgument.InvalidArgumentException;
import br.com.viktor.javawebpoc.exception.invalidArgument.InvalidStudentException;
import br.com.viktor.javawebpoc.facade.StudentFacade;
import br.com.viktor.javawebpoc.validation.StudentValidator;

@Controller
@RequestMapping("/student")
public class StudentController extends AbstractCrudController<Student>  {
	
	private StudentValidator validator;

	@Inject
	public StudentController(StudentFacade facade, StudentValidator validator) {
		super(facade);
		this.validator = validator;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		//Set @Valid to use StudentValidator
		binder.setValidator(validator);
	}

	@Override
	protected void validationResult(BindingResult bindingResult) throws InvalidArgumentException {
		if(bindingResult.hasErrors()){
				throw new InvalidStudentException(bindingResult.getAllErrors());
		}
	}
}