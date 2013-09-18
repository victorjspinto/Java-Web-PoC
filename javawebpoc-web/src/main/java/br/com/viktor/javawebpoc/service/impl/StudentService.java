package br.com.viktor.javawebpoc.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.exception.EntityExistsException;
import br.com.viktor.javawebpoc.exception.InvalidArgumentException;
import br.com.viktor.javawebpoc.repository.StudentRepositoryContract;
import br.com.viktor.javawebpoc.service.contract.StudentServiceContract;
import br.com.viktor.javawebpoc.service.impl.base.AbstractCrudService;

@Service
public class StudentService extends AbstractCrudService<Student> implements
		StudentServiceContract {

	protected StudentRepositoryContract studentRepository;

	@Inject
	public StudentService(StudentRepositoryContract repository) {
		super(repository);
		this.studentRepository = repository;
	}

	@Override
	protected void checkBussinessKey(Student entity)
			throws EntityExistsException {
		Student test = this.studentRepository.findByName(entity.getName());
		if (test != null)
			throw new EntityExistsException(
					"Ja existe um estudante com o nome informado", test);
	}

	@Override
	protected void checkIfValid(Student entity) throws InvalidArgumentException {
		Map<String, String> validationResult = new HashMap<String, String>();

		if (entity.getName() == null)
			validationResult.put("name", "O nome nao pode ser nulo.");
		else {
			if (entity.getName().length() < 10)
				validationResult.put("name",
						"O nome precisa ter pelo menos 10 caracteres.");
		}
		
		if(validationResult.size() > 0)
			throw new InvalidArgumentException("O Estudante possui dados invalidos.", validationResult);
	}
}
