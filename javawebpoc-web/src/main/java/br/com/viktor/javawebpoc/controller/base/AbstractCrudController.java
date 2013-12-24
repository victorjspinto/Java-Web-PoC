package br.com.viktor.javawebpoc.controller.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.viktor.javawebpoc.entity.base.AbstractEntity;
import br.com.viktor.javawebpoc.exception.alreadyExists.AlreadyExistsException;
import br.com.viktor.javawebpoc.exception.invalidArgument.InvalidArgumentException;
import br.com.viktor.javawebpoc.exception.invalidArgument.NullArgumentException;
import br.com.viktor.javawebpoc.exception.notFound.NotFoundException;
import br.com.viktor.javawebpoc.facade.base.AbstractCrudFacade;

public abstract class AbstractCrudController<T extends AbstractEntity> {

	protected AbstractCrudFacade<T> facade;

	public AbstractCrudController(AbstractCrudFacade<T> facade) {
		this.facade = facade;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T> list() {
		return facade.list();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public T find(@PathVariable("id") long id) throws NotFoundException, NullArgumentException {
		return facade.find(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody T data, BindingResult bindingResult, UriComponentsBuilder cp, HttpServletRequest request, HttpServletResponse response) throws AlreadyExistsException, NullArgumentException, InvalidArgumentException {
		validationResult(bindingResult);
		
		UriComponents uriComponent = cp.path(request.getPathInfo() + "/{id}").buildAndExpand(1L);
		facade.save(data);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponent.toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void update(@ModelAttribute T data) throws NotFoundException, NullArgumentException {
		facade.update(data);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) throws NotFoundException, NullArgumentException {
		facade.delete(id);
	}
	
	protected abstract void validationResult(BindingResult bindingResult) throws InvalidArgumentException;
	
}