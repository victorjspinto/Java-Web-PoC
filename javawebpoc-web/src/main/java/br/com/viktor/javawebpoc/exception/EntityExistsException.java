package br.com.viktor.javawebpoc.exception;

public class EntityExistsException extends JavaWebPoCException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4891693682871117448L;

	private Object currentEntity;
	
	public EntityExistsException() {
		super();
	}

	public EntityExistsException(String message) {
		super(message);
	}
	
	public EntityExistsException(String message, Object currentEntity) {
		super(message);
		this.currentEntity = currentEntity;
	}

	public EntityExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityExistsException(Throwable cause) {
		super(cause);
	}

	public Object getCurrentEntity() {
		return currentEntity;
	}

	public void setCurrentEntity(Object currentEntity) {
		this.currentEntity = currentEntity;
	}
}
