package io.github.lordviktor.javawebpoc.webapp.validation.util;

public enum ErrorCode {

	REQUIRED(0), STRINGLENGTH(1);

	private int code;

	ErrorCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

}
