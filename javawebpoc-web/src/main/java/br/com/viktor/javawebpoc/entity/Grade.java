package br.com.viktor.javawebpoc.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.viktor.javawebpoc.entity.base.AbstractEntity;

@Entity
@Table(name = "TB_GRADE")
public class Grade extends AbstractEntity {
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Student student;
	
	private Float score;
	
	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}