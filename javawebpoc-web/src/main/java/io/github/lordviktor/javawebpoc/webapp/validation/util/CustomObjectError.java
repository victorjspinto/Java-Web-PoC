package io.github.lordviktor.javawebpoc.webapp.validation.util;

import io.github.lordviktor.javawebpoc.core.l10n.MessageKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.validation.ObjectError;

public class CustomObjectError extends ObjectError {

	private static final long serialVersionUID = -5849582471636809411L;
	private ErrorCode code;
	private String propertyName;
	private String[] args;
	private MessageKey propertyMessage;
	private MessageKey validationMessage;

	public CustomObjectError(ErrorCode code, String propertyName,
			MessageKey propertyMessage, MessageKey validationMessage,
			String... args) {
		super(propertyName, validationMessage.getMessageKey());

		this.code = code;
		this.propertyName = propertyName;
		this.args = args;
		this.propertyMessage = propertyMessage;
		this.validationMessage = validationMessage;
	}

	public ValidationResult getMessage(MessageSource messageSource,
			Locale locale) {

		String localizedPropertyName = messageSource.getMessage(
				this.propertyMessage.getMessageKey(), new Object[0], locale);

		List<Object> args = new ArrayList<Object>();
		args.add(localizedPropertyName);
		args.addAll(args);

		String localizedValidationMessage = messageSource.getMessage(
				this.validationMessage.getMessageKey(), args.toArray(), locale);

		ValidationResult validationResult = new ValidationResult();
		validationResult.setCode(code.getCode());
		validationResult.setField(propertyName);
		validationResult.setMessage(localizedValidationMessage);

		return validationResult;
	}
}
