package io.github.lordviktor.javawebpoc.webapp.controller.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
//	@ExceptionHandler(value = NotFoundException.class)
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	@ResponseBody
//	public ErrorResponse entityNotExistExceptionHandler(NotFoundException ex, Locale locale) {
//		ErrorResponse response = ex.getMessage(messageSource, locale);
//		return response;
//	}
//
//	@ExceptionHandler(value = InvalidArgumentException.class)
//	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
//	@ResponseBody
//	public ErrorResponse invalidArgumentExceptionHandler(InvalidArgumentException ex, Locale locale) {
//		ErrorResponse response = ex.getMessage(messageSource, locale);
//		return response;
//	}
//
//	@ExceptionHandler(value = AlreadyExistsException.class)
//	@ResponseStatus(value = HttpStatus.CONFLICT) 
//	@ResponseBody
//	public ErrorResponse entityExistExceptionHandler(AlreadyExistsException ex, Locale locale) {
//		ErrorResponse response = ex.getMessage(messageSource, locale);
//		return response;
//	}
//	
//	@ExceptionHandler(JavaWebPoCException.class)
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ResponseBody
//	public ErrorResponse generalExceptionHandler(JavaWebPoCException ex, Locale locale) {
//		ErrorResponse response = ex.getMessage(messageSource, locale);
//		return response;
//	}
		
}