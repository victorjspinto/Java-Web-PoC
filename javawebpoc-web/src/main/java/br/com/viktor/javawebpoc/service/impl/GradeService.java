package br.com.viktor.javawebpoc.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;

import org.springframework.stereotype.Service;

import br.com.viktor.javawebpoc.entity.Grade;
import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.exception.alreadyExists.AlreadyExistsException;
import br.com.viktor.javawebpoc.exception.invalidArgument.InvalidArgumentException;
import br.com.viktor.javawebpoc.exception.notFound.NotFoundException;
import br.com.viktor.javawebpoc.repository.GradeRepositoryContract;
import br.com.viktor.javawebpoc.service.contract.GradeServiceContract;
import br.com.viktor.javawebpoc.service.impl.base.AbstractCrudService;

@Service
public class GradeService extends AbstractCrudService<Grade> implements GradeServiceContract {

	private GradeRepositoryContract gradeRepository;

	@Inject
	public GradeService(GradeRepositoryContract gradeRepository) {
		super(gradeRepository);
		this.gradeRepository = gradeRepository;
	}

	@Override
	protected void checkIfValid(Grade entity) throws InvalidArgumentException {
		if(entity.getScore() > 10 || entity.getScore() < 0){
			throw new InvalidArgumentException();
		}
		
	}

	@Override
	protected void checkBussinessKey(Grade entity)
			throws AlreadyExistsException {
		try {
			if(this.find(entity.getId()) != null)
				throw new EntityExistsException();
		} catch (NotFoundException e) {}

	}

	@Override
	public List<Grade> findAllByStudent(Student student) {
		return gradeRepository.findAllByStudent(student);
	}

}
