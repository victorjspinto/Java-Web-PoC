package br.com.viktor.javawebpoc.exception.alreadyExists;

import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.l10n.MessageKey;

public class StudentExistsException extends AlreadyExistsException {

	private static final long serialVersionUID = 1L;
	private Student student;
	
	public StudentExistsException(Student student) {
		super(MessageKey.STUDENTEXISTS_EXCEPTION, new Object[] { student });
		this.setStudent(student);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
