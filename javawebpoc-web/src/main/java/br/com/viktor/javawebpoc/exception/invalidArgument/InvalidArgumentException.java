package br.com.viktor.javawebpoc.exception.invalidArgument;

import java.util.List;

import org.springframework.validation.ObjectError;

import br.com.viktor.javawebpoc.exception.JavaWebPoCException;
import br.com.viktor.javawebpoc.l10n.MessageKey;

public class InvalidArgumentException extends JavaWebPoCException {

	private static final long serialVersionUID = -3625290134962357049L;
	private List<ObjectError> errors;

	public InvalidArgumentException() {
		super(MessageKey.INVALIDARGUMENT_EXCEPTION, new Object[] {});
	}
	
	public InvalidArgumentException(List<ObjectError> errors) {
		this(MessageKey.INVALIDARGUMENT_EXCEPTION, errors);
	}
	
	protected InvalidArgumentException(MessageKey key, List<ObjectError> errors) {
		super(key, errors.toArray());
		this.setErrors(errors);
	}

	public List<ObjectError> getErrors() {
		return errors;
	}

	public void setErrors(List<ObjectError> errors) {
		this.errors = errors;
	}

}