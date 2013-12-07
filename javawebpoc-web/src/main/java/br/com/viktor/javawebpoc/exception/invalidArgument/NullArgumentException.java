package br.com.viktor.javawebpoc.exception.invalidArgument;

import br.com.viktor.javawebpoc.exception.JavaWebPoCException;
import br.com.viktor.javawebpoc.l10n.MessageKey;

public class NullArgumentException extends JavaWebPoCException {

	private static final long serialVersionUID = -7797481870386881968L;
	private String property;

	public NullArgumentException() {
		super(MessageKey.NULLARGUMENT_EXCEPTION, new Object[] {});
	}
	
	public NullArgumentException(String property) {
		super(MessageKey.NULLARGUMENT_EXCEPTION, new Object[] { property });
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
}
