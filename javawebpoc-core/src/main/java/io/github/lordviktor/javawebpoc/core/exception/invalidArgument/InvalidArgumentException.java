package io.github.lordviktor.javawebpoc.core.exception.invalidArgument;

import io.github.lordviktor.javawebpoc.core.exception.ErrorResponse;
import io.github.lordviktor.javawebpoc.core.exception.JavaWebPoCException;
import io.github.lordviktor.javawebpoc.core.l10n.MessageKey;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.validation.ObjectError;

public class InvalidArgumentException extends JavaWebPoCException {

	private static final long serialVersionUID = -3625290134962357049L;

	public InvalidArgumentException() {
		super(MessageKey.INVALIDARGUMENT_EXCEPTION, new Object[] {});
	}

	public InvalidArgumentException(List<ObjectError> errors) {
		this(MessageKey.INVALIDARGUMENT_EXCEPTION, errors);
	}

	public InvalidArgumentException(MessageKey key, List<ObjectError> errors) {
		super(key, errors.toArray());
		this.setErrors(errors);
	}

	@Override
	public ErrorResponse getMessage(MessageSource messageSource, Locale locale) {
//		if (errors == null)
//			return super.getMessage(messageSource, locale);
//		else {
//			ValidationErrorResponse response = new ValidationErrorResponse();
//			String message = messageSource.getMessage(getMessageKey()
//					.getMessageKey(), getMessageArgs(), locale);
//			message = messageSource.getMessage(
//					MessageKey.VALIDATION_INVALID.getMessageKey(),
//					new Object[] { message }, locale);
//			response.setMessage(message);
//
//			List<ValidationResult> results = new ArrayList<ValidationResult>();
//			for (ObjectError error : errors) {
//				if (error instanceof CustomObjectError)
//					results.add(((CustomObjectError) error).getMessage(
//							messageSource, locale));
//				else {
//					// TODO:Pensar em alternativa
//				}
//				response.setValidationResults(results);
//				// response.getValidationResults().add(
//				// messageSource.getMessage(error, locale));
//			}
//			return response;
//		}
	  return null;
	}

	protected void setErrors(List<ObjectError> errors) {
		//this.errors = errors;
	}
}