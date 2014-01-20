package br.com.viktor.javawebpoc.service.contract.base;

import java.util.List;

import br.com.viktor.javawebpoc.entity.base.AbstractEntity;
import br.com.viktor.javawebpoc.exception.alreadyExists.AlreadyExistsException;
import br.com.viktor.javawebpoc.exception.invalidArgument.InvalidArgumentException;
import br.com.viktor.javawebpoc.exception.invalidArgument.NullArgumentException;
import br.com.viktor.javawebpoc.exception.notFound.NotFoundException;

public interface AbstractCrudContract<E extends AbstractEntity> {
	public E save(E entity) throws AlreadyExistsException, NullArgumentException, InvalidArgumentException;

	public void update(E entity)throws NotFoundException, NullArgumentException;

	public void delete(E entity) throws NotFoundException, NullArgumentException;

	public void delete(Long id) throws NotFoundException, NullArgumentException;

	public List<E> list();

	public E get(E entity) throws NotFoundException, NullArgumentException;
	
	public E find(long id) throws NotFoundException, NullArgumentException;

}
