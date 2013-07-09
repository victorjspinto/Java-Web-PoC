package br.com.viktor.javawebpoc.exception;

import java.util.Map;

public class InvalidArgumentException extends JavaWebPoCException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3625290134962357049L;

	private Map<String, String> validationResult;

	public InvalidArgumentException(String message, Map<String, String> validationResult) {
		super(message);
		this.validationResult = validationResult;
	}

	public InvalidArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidArgumentException(Throwable cause) {
		super(cause);
	}

	public Map<String, String> getValidationResult() {
		return validationResult;
	}

	public void setValidationResult(Map<String, String> validationResult) {
		this.validationResult = validationResult;
	}
}
