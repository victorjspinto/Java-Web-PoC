package io.github.lordviktor.javawebpoc.core.service.base;

import io.github.lordviktor.javawebpoc.core.exception.alreadyExists.AlreadyExistsException;
import io.github.lordviktor.javawebpoc.core.exception.invalidArgument.InvalidArgumentException;
import io.github.lordviktor.javawebpoc.core.exception.invalidArgument.NullArgumentException;
import io.github.lordviktor.javawebpoc.core.exception.notFound.NotFoundException;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.viktor.javawebpoc.entity.base.AbstractEntity;

public abstract class AbstractCrudService<T extends AbstractEntity> {

	private JpaRepository<T, Long> repository;

	protected JpaRepository<T, Long> getRepository() {
		return repository;
	}

	public AbstractCrudService(JpaRepository<T, Long> repository) {
		this.repository = repository;
	}

	public T save(T entity) throws AlreadyExistsException, NullArgumentException, InvalidArgumentException {

		checkIfNull(entity);

		checkIfValid(entity);

		checkBussinessKey(entity);

		return repository.save(entity);
	}

	public void delete(T entity) throws NotFoundException {
		repository.delete(entity);
	}

	public void update(T entity) throws NotFoundException {
		repository.save(entity);
	}

	public List<T> list() {
		return repository.findAll();
	}

	public T get(T entity) throws NotFoundException {
		return repository.findOne(entity.getId());
	}

	public T find(long id) throws NotFoundException {
		T t = repository.findOne(id);
		if (t == null)
			throw new NotFoundException();
		return t;
	}

	public void delete(Long id) throws NotFoundException {
		T t = repository.findOne(id);
		if (t == null)
			throw new NotFoundException();
		repository.delete(t);
	}

	protected abstract void checkIfValid(T entity) throws InvalidArgumentException;

	protected abstract void checkBussinessKey(T entity)
			throws AlreadyExistsException;
	
	private void checkIfNull(T entity) throws NullArgumentException {
		if (entity == null)
			throw new NullArgumentException();
	}
}
