package br.com.viktor.javawebpoc.controller.util;

public class ErrorResponse {

	private String message;
	
	private String description;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
