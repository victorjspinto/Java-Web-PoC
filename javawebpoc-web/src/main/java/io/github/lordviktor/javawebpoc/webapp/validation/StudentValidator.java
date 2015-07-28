package io.github.lordviktor.javawebpoc.webapp.validation;

import io.github.lordviktor.javawebpoc.persistence.entity.Student;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;


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