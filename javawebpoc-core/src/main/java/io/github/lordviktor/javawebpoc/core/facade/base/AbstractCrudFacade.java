package io.github.lordviktor.javawebpoc.core.facade.base;

import io.github.lordviktor.javawebpoc.core.exception.alreadyExists.AlreadyExistsException;
import io.github.lordviktor.javawebpoc.core.exception.invalidArgument.InvalidArgumentException;
import io.github.lordviktor.javawebpoc.core.exception.invalidArgument.NullArgumentException;
import io.github.lordviktor.javawebpoc.core.exception.notFound.NotFoundException;
import io.github.lordviktor.javawebpoc.core.service.base.AbstractCrudService;
import io.github.lordviktor.javawebpoc.persistence.entity.base.AbstractEntity;

import java.util.List;

public abstract class AbstractCrudFacade<T extends AbstractEntity> {
	
	private AbstractCrudService<T> abstractCrud;
	
	public AbstractCrudFacade(AbstractCrudService<T> abstractCrud){
		this.abstractCrud = abstractCrud;
	}
	
	public T save(T entity) throws AlreadyExistsException, NullArgumentException, InvalidArgumentException {
		return this.abstractCrud.save(entity);
	}
	
	public void delete(T entity) throws NotFoundException, NullArgumentException {
		this.abstractCrud.delete(entity.getId());
	}

	public void update(T entity) throws NotFoundException, NullArgumentException {
		this.abstractCrud.update(entity);
	}

	public List<T> list() {
		return this.abstractCrud.list();
	}

	public T get(T entity) throws NotFoundException, NullArgumentException {
		return this.abstractCrud.get(entity);
	}

	public T find(long id) throws NotFoundException, NullArgumentException {
		return this.abstractCrud.find(id);
	}

	public void delete(Long id) throws NotFoundException, NullArgumentException {
		this.abstractCrud.delete(id);
	}

}
