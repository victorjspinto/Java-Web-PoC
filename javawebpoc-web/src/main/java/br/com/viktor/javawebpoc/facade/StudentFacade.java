package br.com.viktor.javawebpoc.facade;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.viktor.javawebpoc.entity.Grade;
import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.exception.invalidArgument.NullArgumentException;
import br.com.viktor.javawebpoc.exception.notFound.NotFoundException;
import br.com.viktor.javawebpoc.facade.base.AbstractCrudFacade;
import br.com.viktor.javawebpoc.service.contract.GradeServiceContract;
import br.com.viktor.javawebpoc.service.contract.StudentServiceContract;

@Component
@Transactional
public class StudentFacade extends AbstractCrudFacade<Student> {

	private StudentServiceContract studentService;
	private GradeServiceContract gradeService;

	public StudentFacade(){
		super(null);
	}
	
	@Inject
	public StudentFacade(StudentServiceContract studentService, GradeServiceContract gradeService) {
		super(studentService);
		this.studentService = studentService;
		this.gradeService = gradeService;
	}
	
	public List<Grade> findAllByStudentId(Long studentId) throws NotFoundException, NullArgumentException{
		return this.gradeService.findAllByStudent(this.studentService.find(studentId));
	}

}