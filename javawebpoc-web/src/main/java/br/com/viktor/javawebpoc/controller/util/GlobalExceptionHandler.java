package br.com.viktor.javawebpoc.controller.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.viktor.javawebpoc.exception.EntityNotExistException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = IllegalArgumentException.class)
	@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY)
	public @ResponseBody void validationExceptionHandler() {
		
	}
	
	@ExceptionHandler(value = EntityNotExistException.class)
	@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY)
	public @ResponseBody ErrorResponse entityNotExistExceptionHandler(EntityNotExistException ex) {
		ErrorResponse response = new ErrorResponse();
		
		response.setMessage(ex.getMessage());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
}
