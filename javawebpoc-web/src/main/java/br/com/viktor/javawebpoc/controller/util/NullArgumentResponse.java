package br.com.viktor.javawebpoc.controller.util;

public class NullArgumentResponse extends ErrorResponse {
	private String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
}
