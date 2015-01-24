package br.com.viktor.javawebpoc.controller.base;

import io.github.lordviktor.javawebpoc.core.exception.alreadyExists.AlreadyExistsException;
import io.github.lordviktor.javawebpoc.core.exception.invalidArgument.InvalidArgumentException;
import io.github.lordviktor.javawebpoc.core.exception.invalidArgument.NullArgumentException;
import io.github.lordviktor.javawebpoc.core.exception.notFound.NotFoundException;
import io.github.lordviktor.javawebpoc.core.facade.base.AbstractCrudFacade;
import io.github.lordviktor.javawebpoc.core.l10n.MessageKey;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

public abstract class AbstractCrudController<T extends AbstractEntity> {

	protected AbstractCrudFacade<T> facade;
	private Validator validator;
	private MessageKey message;

	public AbstractCrudController(AbstractCrudFacade<T> facade,
			Validator validator, MessageKey message) {
		this.facade = facade;
		this.validator = validator;
		this.message = message;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// Set @Valid to use
		binder.setValidator(validator);
	}

	protected void validationResult(BindingResult bindingResult)
			throws InvalidArgumentException {
		if (bindingResult.hasErrors()) {
			throw new InvalidArgumentException(message,
					bindingResult.getAllErrors());
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T> list() {
		return facade.list();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public T find(@PathVariable("id") long id) throws NotFoundException,
			NullArgumentException {
		return facade.find(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody T data,
			BindingResult bindingResult, UriComponentsBuilder cp,
			HttpServletRequest request, HttpServletResponse response)
			throws AlreadyExistsException, NullArgumentException,
			InvalidArgumentException {
		validationResult(bindingResult);
		T entity = facade.save(data);

		UriComponents uriComponent = cp.path(request.getPathInfo() + "/{id}")
				.buildAndExpand(entity.getId());

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponent.toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void update(@ModelAttribute T data) throws NotFoundException,
			NullArgumentException {
		facade.update(data);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) throws NotFoundException,
			NullArgumentException {
		facade.delete(id);
	}
}