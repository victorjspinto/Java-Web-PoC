package io.github.lordviktor.javawebpoc.webapp.validation;

import io.github.lordviktor.javawebpoc.core.l10n.MessageKey;
import io.github.lordviktor.javawebpoc.persistence.entity.base.AbstractEntity;
import io.github.lordviktor.javawebpoc.webapp.validation.util.CustomObjectError;
import io.github.lordviktor.javawebpoc.webapp.validation.util.ErrorCode;

import org.springframework.util.StringUtils;
import org.springframework.validation.AbstractBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

public abstract class AbstractValidator<T extends AbstractEntity> implements Validator {

	private Class<T> targetClass;
	private Errors errors;

	public AbstractValidator(Class<T> targetClass) {
		this.targetClass = targetClass;
	}

	protected Errors getErrors() {
		return errors;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return targetClass.isAssignableFrom(arg0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void validate(Object arg0, Errors errors) {
		this.errors = errors;

		validate((T) arg0);
	}

	protected void Required(String field) {
		Object fieldValue = errors.getFieldValue(field);
		if (fieldValue == null || !StringUtils.hasText(fieldValue.toString())) {
			addError(new CustomObjectError(ErrorCode.REQUIRED, field,
					MessageKey.NAME, MessageKey.VALIDATION_FIELD_REQUIRED));
		}
	}

	protected abstract void validate(T entity);

	protected void addError(ObjectError error) {
		if (this.getErrors() instanceof AbstractBindingResult)
			((AbstractBindingResult) this.getErrors()).addError(error);
	}
}
