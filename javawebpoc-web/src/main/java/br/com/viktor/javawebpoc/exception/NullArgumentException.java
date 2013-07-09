package br.com.viktor.javawebpoc.exception;

public class NullArgumentException extends JavaWebPoCException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7797481870386881968L;

	private String property;

	public NullArgumentException(String message, String property) {
		super(message);
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
}
