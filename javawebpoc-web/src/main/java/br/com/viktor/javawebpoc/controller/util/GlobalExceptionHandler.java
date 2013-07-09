package br.com.viktor.javawebpoc.controller.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.viktor.javawebpoc.exception.EntityExistsException;
import br.com.viktor.javawebpoc.exception.EntityNotExistException;
import br.com.viktor.javawebpoc.exception.InvalidArgumentException;
import br.com.viktor.javawebpoc.exception.NullArgumentException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public @ResponseBody
	void validationExceptionHandler() {

	}

	@ExceptionHandler(value = EntityNotExistException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public @ResponseBody
	ErrorResponse entityNotExistExceptionHandler(EntityNotExistException ex) {
		ErrorResponse response = new ErrorResponse();

		response.setMessage(ex.getMessage());
		response.setMessage(ex.getMessage());

		return response;
	}

	@ExceptionHandler(value = NullArgumentException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public @ResponseBody
	NullArgumentResponse nullArgumentExceptionHandler(NullArgumentException ex) {
		NullArgumentResponse response = new NullArgumentResponse();

		response.setMessage(ex.getMessage());
		response.setProperty(ex.getProperty());

		return response;
	}

	@ExceptionHandler(value = InvalidArgumentException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public @ResponseBody
	InvalidArgumentResponse invalidArgumentExceptionHandler(
			InvalidArgumentException ex) {
		InvalidArgumentResponse response = new InvalidArgumentResponse();

		response.setMessage(ex.getMessage());
		response.setValidationResult(ex.getValidationResult());

		return response;
	}

	@ExceptionHandler(value = EntityExistsException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public @ResponseBody
	EntityExistResponse entityExistExceptionHandler(EntityExistsException ex) {
		EntityExistResponse response = new EntityExistResponse();

		response.setMessage(ex.getMessage());
		response.setCurrentEntity(ex.getCurrentEntity());

		return response;
	}
}
