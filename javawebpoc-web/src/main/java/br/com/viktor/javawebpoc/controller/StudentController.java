package br.com.viktor.javawebpoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.viktor.javawebpoc.controller.base.AbstractCrudController;
import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.exception.EntityNotExistException;
import br.com.viktor.javawebpoc.service.contract.StudentServiceContract;

@Controller
@RequestMapping("/student")
public class StudentController extends AbstractCrudController<Student>  {

	@Autowired
	public StudentController(StudentServiceContract service) {
		super(service);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(Long id) throws EntityNotExistException {
		service.delete(id);
	}
	
}
