package br.com.viktor.javawebpoc.service.contract;

import java.util.List;

import br.com.viktor.javawebpoc.entity.Grade;
import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.service.contract.base.AbstractCrudContract;

public interface GradeServiceContract extends AbstractCrudContract<Grade> {
	public List<Grade> findAllByStudent(Student student);
}
