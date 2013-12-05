package br.com.viktor.javawebpoc.exception.invalidArgument;

import java.util.Map;

import br.com.viktor.javawebpoc.exception.JavaWebPoCException;
import br.com.viktor.javawebpoc.l10n.MessageKey;

public class InvalidArgumentException extends JavaWebPoCException {

	private static final long serialVersionUID = -3625290134962357049L;
	private Map<String, String> validationResult;

	public InvalidArgumentException() {
		super(MessageKey.INVALIDARGUMENT_EXCEPTION, new Object[] {});
	}
	
	public InvalidArgumentException(Map<String, String> validationResult) {
		this.validationResult = validationResult;
	}

	protected InvalidArgumentException(MessageKey key, Object[] args) {
		super(key, args);
	}

	public Map<String, String> getValidationResult() {
		return validationResult;
	}

	public void setValidationResult(Map<String, String> validationResult) {
		this.validationResult = validationResult;
	}
}
