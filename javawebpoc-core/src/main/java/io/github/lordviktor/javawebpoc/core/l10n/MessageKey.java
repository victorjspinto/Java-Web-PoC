package io.github.lordviktor.javawebpoc.core.l10n;

public enum MessageKey {
	JAVAWEBPOC_EXCEPTION("br.com.viktor.javawebpoc.exception.javawebpocexception"),
	ALREADYEXISTS_EXCEPTION("br.com.viktor.javawebpoc.exception.alreadyexistsexception"),
	STUDENTEXISTS_EXCEPTION("br.com.viktor.javawebpoc.exception.studentexistsexception"),
	INVALIDARGUMENT_EXCEPTION("br.com.viktor.javawebpoc.exception.argumentexception"),
	NULLARGUMENT_EXCEPTION("br.com.viktor.javawebpoc.exception.nullargumentexception"),
	INVALIDSTUDENT_EXCEPTION("br.com.viktor.javawebpoc.exception.invalidstudentexception"),
	NOTFOUND_EXCEPTION("br.com.viktor.javawebpoc.exception.notfoundexception"),

	VALIDATION_INVALID("br.com.viktor.javawebpoc.validation.invalid"),
	VALIDATION_FIELD_REQUIRED("br.com.viktor.javawebpoc.validation.fieldrequired"),
	VALIDATION_STRINGLENGTH("br.com.viktor.javawebpoc.validation.stringlength"),
	
	
	ENTITY_STUDENT("br.com.viktor.javawebpoc.student"),
	NAME("br.com.viktor.javawebpoc.name");
	
	private String messageKey;

	MessageKey(String messageKey){
		this.messageKey = messageKey;
	}

	public String getMessageKey() {
		return messageKey;
	}
}
