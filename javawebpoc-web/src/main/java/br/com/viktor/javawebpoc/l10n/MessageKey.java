package br.com.viktor.javawebpoc.l10n;

public enum MessageKey {
	JAVAWEBPOC_EXCEPTION("br.com.viktor.javawebpoc.exception.javawebpocexception"),
	ALREADYEXISTS_EXCEPTION("br.com.viktor.javawebpoc.exception.alreadyexistsexception"),
	STUDENTEXISTS_EXCEPTION("br.com.viktor.javawebpoc.exception.studentexistsexception"),
	INVALIDARGUMENT_EXCEPTION("br.com.viktor.javawebpoc.exception.argumentexception"),
	NULLARGUMENT_EXCEPTION("br.com.viktor.javawebpoc.exception.nullargumentexception"),
	INVALIDSTUDENT_EXCEPTION("br.com.viktor.javawebpoc.exception.invalidstudentexception"),
	NOTFOUND_EXCEPTION("br.com.viktor.javawebpoc.exception.notfoundexception"),
	
	STUDENTINVALID_VALIDATION("br.com.viktor.javawebpoc.validation.studentinvalid"),
	STUDENTNAMENULL_VALIDATION("br.com.viktor.javawebpoc.validation.studentnamenull"),
	STUDENTNAMESIZE_VALIDATION("br.com.viktor.javawebpoc.validation.studentnamesize");
	
	private String messageKey;

	MessageKey(String messageKey){
		this.messageKey = messageKey;
	}

	public String getMessageKey() {
		return messageKey;
	}
}
