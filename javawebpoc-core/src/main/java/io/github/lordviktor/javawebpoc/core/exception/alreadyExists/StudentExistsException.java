package io.github.lordviktor.javawebpoc.core.exception.alreadyExists;

import io.github.lordviktor.javawebpoc.core.l10n.MessageKey;
import br.com.viktor.javawebpoc.entity.Student;

public class StudentExistsException extends AlreadyExistsException {

	private static final long serialVersionUID = 1L;
	private Student student;
	
	public StudentExistsException(Student student) {
		super(MessageKey.STUDENTEXISTS_EXCEPTION, new Object[] { student.toString() });
		this.setStudent(student);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
