package br.com.viktor.javawebpoc.l10n;

public enum MessageKey {
	JAVAWEBPOC_EXCEPTION("br.com.viktor.javawebpoc.error.javawebpocexception"),

	ALREADYEXISTS_EXCEPTION("br.com.viktor.javawebpoc.error.alreadyexistsexception"),
	STUDENTEXISTS_EXCEPTION("br.com.viktor.javawebpoc.error.studentexistsexception"),
	
	INVALIDARGUMENT_EXCEPTION("br.com.viktor.javawebpoc.error.argumentexception"),
	NULLARGUMENT_EXCEPTION("br.com.viktor.javawebpoc.error.nullargumentexception"),
	INVALIDSTUDENT_EXCEPTION("br.com.viktor.javawebpoc.error.invalidstudentexception"),
	
	NOTFOUND_EXCEPTION("br.com.viktor.javawebpoc.error.notfoundexception");
	
	private String messageKey;

	MessageKey(String messageKey){
		this.messageKey = messageKey;
	}

	public String getMessageKey() {
		return messageKey;
	}
}
