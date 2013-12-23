package br.com.viktor.javawebpoc.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.exception.alreadyExists.StudentExistsException;
import br.com.viktor.javawebpoc.exception.invalidArgument.InvalidStudentException;
import br.com.viktor.javawebpoc.repository.StudentRepositoryContract;
import br.com.viktor.javawebpoc.service.contract.StudentServiceContract;
import br.com.viktor.javawebpoc.service.impl.base.AbstractCrudService;
import br.com.viktor.javawebpoc.validation.StudentValidator;

@Service
public class StudentService extends AbstractCrudService<Student> implements StudentServiceContract {

	protected StudentRepositoryContract studentRepository;
	private Validator validator;
	
	@Inject
	public StudentService(StudentRepositoryContract repository, StudentValidator validator) {
		super(repository);
		this.studentRepository = repository;
		this.validator = validator;
	}

	@Override
	protected void checkBussinessKey(Student entity) throws StudentExistsException {
		Student test = this.studentRepository.findByName(entity.getName());
		if (test != null)
			throw new StudentExistsException(test);
	}

	@Override
	protected void checkIfValid(Student entity) throws InvalidStudentException {
		BindException errors = new BindException(entity, "student");
		this.validator.validate(entity, errors);
		
		if(errors.hasErrors()){
			throw new InvalidStudentException(errors.getAllErrors());
		}
	}
}