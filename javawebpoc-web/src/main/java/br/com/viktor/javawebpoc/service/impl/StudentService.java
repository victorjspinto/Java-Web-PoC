package br.com.viktor.javawebpoc.service.impl.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.repository.StudentRepositoryContract;
import br.com.viktor.javawebpoc.service.contract.StudentServiceContract;

@Service
public class StudentService extends AbstractCrudService<Student> implements
		StudentServiceContract {

	@Autowired
	public StudentService(StudentRepositoryContract repository) {
		super(repository);

	}

}
