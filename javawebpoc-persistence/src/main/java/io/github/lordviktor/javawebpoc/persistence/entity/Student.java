package io.github.lordviktor.javawebpoc.persistence.entity;

import io.github.lordviktor.javawebpoc.persistence.entity.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_STUDENT", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
public class Student extends AbstractEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getId() + " " + getName();
	}
}
