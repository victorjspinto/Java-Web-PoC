package br.com.viktor.javawebpoc.service.contract.base;

import java.util.List;

import br.com.viktor.javawebpoc.entity.base.AbstractEntity;
import br.com.viktor.javawebpoc.exception.EntityExistsException;
import br.com.viktor.javawebpoc.exception.EntityNotExistException;
import br.com.viktor.javawebpoc.exception.InvalidArgumentException;
import br.com.viktor.javawebpoc.exception.NullArgumentException;

public interface AbstractCrudContract<E extends AbstractEntity> {
	public void save(E entity) throws EntityExistsException, NullArgumentException, InvalidArgumentException;

	public void update(E entity)throws EntityNotExistException, NullArgumentException;

	public void delete(E entity) throws EntityNotExistException, NullArgumentException;

	public void delete(Long id) throws EntityNotExistException, NullArgumentException;

	public List<E> list();

	public E get(E entity) throws EntityNotExistException, NullArgumentException;
	
	public E find(long id) throws EntityNotExistException, NullArgumentException;

}
