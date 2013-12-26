package br.com.viktor.javawebpoc.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.l10n.MessageKey;

@Component
public class StudentValidator implements Validator {

	public void validate(Object target, Errors errors) {
		Student entity = (Student)target;
		if (entity.getName() == null)
			errors.rejectValue("name", MessageKey.STUDENTNAMENULL_VALIDATION.getMessageKey());
		else {
			if (entity.getName().length() < 10)
				errors.rejectValue("name", 
						MessageKey.STUDENTNAMESIZE_VALIDATION.getMessageKey(), new Object[] { 10, 50 }, 
						MessageKey.STUDENTINVALID_VALIDATION.getMessageKey());
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
	}

}