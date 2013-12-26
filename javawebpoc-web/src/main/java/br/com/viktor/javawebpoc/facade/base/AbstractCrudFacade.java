package br.com.viktor.javawebpoc.facade.base;

import java.util.List;

import br.com.viktor.javawebpoc.entity.base.AbstractEntity;
import br.com.viktor.javawebpoc.exception.alreadyExists.AlreadyExistsException;
import br.com.viktor.javawebpoc.exception.invalidArgument.InvalidArgumentException;
import br.com.viktor.javawebpoc.exception.invalidArgument.NullArgumentException;
import br.com.viktor.javawebpoc.exception.notFound.NotFoundException;
import br.com.viktor.javawebpoc.service.contract.base.AbstractCrudContract;

public abstract class AbstractCrudFacade<T extends AbstractEntity> {
	
	private AbstractCrudContract<T> abstractCrud;
	
	public AbstractCrudFacade(AbstractCrudContract<T> abstractCrud){
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
