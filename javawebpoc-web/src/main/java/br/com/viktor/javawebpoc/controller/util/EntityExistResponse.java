package br.com.viktor.javawebpoc.controller.util;

public class EntityExistResponse extends ErrorResponse{

	private Object currentEntity;

	public Object getCurrentEntity() {
		return currentEntity;
	}

	public void setCurrentEntity(Object currentEntity) {
		this.currentEntity = currentEntity;
	}
	
}
