package br.com.viktor.javawebpoc.exception.invalidArgument;

import java.util.Map;

import br.com.viktor.javawebpoc.l10n.MessageKey;

public class InvalidStudentException extends InvalidArgumentException {

	private static final long serialVersionUID = 1L;
	
	public InvalidStudentException(Map<String, String> validationResult) {
		super(MessageKey.INVALIDSTUDENT_EXCEPTION, new Object[] { validationResult });
	}

}
