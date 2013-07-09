package br.com.viktor.javawebpoc.controller.util;

import java.util.Map;

public class InvalidArgumentResponse extends ErrorResponse{

	private Map<String, String> validationResult;

	public Map<String, String> getValidationResult() {
		return validationResult;
	}

	public void setValidationResult(Map<String, String> validationResult) {
		this.validationResult = validationResult;
	}
	
}
