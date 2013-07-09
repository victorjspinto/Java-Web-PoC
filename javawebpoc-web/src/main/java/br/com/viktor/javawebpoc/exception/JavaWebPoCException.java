package br.com.viktor.javawebpoc.exception;

public class JavaWebPoCException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1427674583844371960L;

	public JavaWebPoCException() {
		super();
	}

	public JavaWebPoCException(String message) {
		super(message);
	}

	public JavaWebPoCException(String message, Throwable cause) {
		super(message, cause);
	}

	public JavaWebPoCException(Throwable cause) {
		super(cause);
	}
}
