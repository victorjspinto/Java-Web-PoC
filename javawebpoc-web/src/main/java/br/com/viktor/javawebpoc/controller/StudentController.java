package br.com.viktor.javawebpoc.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.viktor.javawebpoc.controller.base.AbstractCrudController;
import br.com.viktor.javawebpoc.entity.Grade;
import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.exception.invalidArgument.NullArgumentException;
import br.com.viktor.javawebpoc.exception.notFound.NotFoundException;
import br.com.viktor.javawebpoc.facade.StudentFacade;

@Controller
@RequestMapping("/student")
public class StudentController extends AbstractCrudController<Student>  {

	private StudentFacade studentFacade;

	@Inject
	public StudentController(StudentFacade studentFacade) {
		super(studentFacade);
		this.studentFacade = studentFacade;
	}
	
	@RequestMapping(value = "/{studentId}/grade", method = RequestMethod.GET)
	@ResponseBody
	public List<Grade> findAllGradeByStudentId(@PathVariable Long studentId) throws NotFoundException, NullArgumentException{
		return studentFacade.findAllByStudentId(studentId);
	}
}
