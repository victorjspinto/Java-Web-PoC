package br.com.viktor.javawebpoc.service.contract.base;

import java.util.List;

import br.com.viktor.javawebpoc.entity.base.AbstractEntity;
import br.com.viktor.javawebpoc.exception.EntityExistsException;
import br.com.viktor.javawebpoc.exception.EntityNotExistException;

public interface AbstractCrudContract<E extends AbstractEntity> {
	public void save(E entity) throws EntityExistsException;

	public void update(E entity)throws EntityNotExistException;

	public void delete(E entity) throws EntityNotExistException;

	public void delete(Long id) throws EntityNotExistException;

	public List<E> list();

	public E get(E entity) throws EntityNotExistException;
	
	public E find(long id) throws EntityNotExistException;

}
