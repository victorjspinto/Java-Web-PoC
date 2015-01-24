package br.com.viktor.javawebpoc.controller.util;

import io.github.lordviktor.javawebpoc.core.exception.ErrorResponse;

import java.util.Collections;
import java.util.List;

import br.com.viktor.javawebpoc.validation.util.ValidationResult;

public class ValidationErrorResponse extends ErrorResponse {

	List<ValidationResult> validationResults = Collections.emptyList();

	public List<ValidationResult> getValidationResults() {
		return validationResults;
	}

	public void setValidationResults(List<ValidationResult> validationResults) {
		this.validationResults = validationResults;
	}

}
