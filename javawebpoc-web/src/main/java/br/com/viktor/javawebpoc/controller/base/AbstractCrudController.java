package br.com.viktor.javawebpoc.controller.base;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.viktor.javawebpoc.entity.base.AbstractEntity;
import br.com.viktor.javawebpoc.exception.EntityExistsException;
import br.com.viktor.javawebpoc.exception.EntityNotExistException;
import br.com.viktor.javawebpoc.exception.InvalidArgumentException;
import br.com.viktor.javawebpoc.exception.NullArgumentException;
import br.com.viktor.javawebpoc.service.contract.base.AbstractCrudContract;

public class AbstractCrudController<T extends AbstractEntity> {

	protected AbstractCrudContract<T> service;

	public AbstractCrudController(AbstractCrudContract<T> service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T> list() {
		return service.list();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public T find(@PathVariable("id") long id) throws EntityNotExistException, NullArgumentException {
		return service.find(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(@ModelAttribute T data) throws EntityExistsException, NullArgumentException, InvalidArgumentException {
		service.save(data);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void update(@ModelAttribute T data) throws EntityNotExistException, NullArgumentException {
		service.update(data);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) throws EntityNotExistException, NullArgumentException {
		service.delete(id);
	}
}