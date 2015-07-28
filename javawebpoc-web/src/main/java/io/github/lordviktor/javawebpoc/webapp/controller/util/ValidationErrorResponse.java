package io.github.lordviktor.javawebpoc.webapp.controller.util;

import io.github.lordviktor.javawebpoc.core.exception.ErrorResponse;
import io.github.lordviktor.javawebpoc.webapp.validation.util.ValidationResult;

import java.util.Collections;
import java.util.List;

public class ValidationErrorResponse extends ErrorResponse {

	List<ValidationResult> validationResults = Collections.emptyList();

	public List<ValidationResult> getValidationResults() {
		return validationResults;
	}

	public void setValidationResults(List<ValidationResult> validationResults) {
		this.validationResults = validationResults;
	}

}
