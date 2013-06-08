package br.com.viktor.javawebpoc.entity;

import br.com.viktor.javawebpoc.entity.base.AbstractEntity;

public class Student extends AbstractEntity {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
