package br.com.viktor.javawebpoc.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

import br.com.viktor.javawebpoc.entity.Student;


@Component
public class StudentValidator extends AbstractValidator<Student> implements Validator {

	public StudentValidator() {
		super(Student.class);
	}

	@Override
	protected void validate(Student entity) {

		super.Required("name");
		
	}
}