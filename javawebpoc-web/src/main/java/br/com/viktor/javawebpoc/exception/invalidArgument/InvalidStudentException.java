package br.com.viktor.javawebpoc.exception.invalidArgument;

import java.util.List;

import org.springframework.validation.ObjectError;

import br.com.viktor.javawebpoc.l10n.MessageKey;

public class InvalidStudentException extends InvalidArgumentException {

	private static final long serialVersionUID = 1L;
		
	public InvalidStudentException(List<ObjectError> errors) {
		super(MessageKey.INVALIDSTUDENT_EXCEPTION, errors);
	}
	
}
