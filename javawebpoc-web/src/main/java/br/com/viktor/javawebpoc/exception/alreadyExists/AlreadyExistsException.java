package br.com.viktor.javawebpoc.exception.alreadyExists;

import br.com.viktor.javawebpoc.exception.JavaWebPoCException;
import br.com.viktor.javawebpoc.l10n.MessageKey;

public class AlreadyExistsException extends JavaWebPoCException {

	private static final long serialVersionUID = 1L;

	public AlreadyExistsException() {
		super(MessageKey.ALREADYEXISTS_EXCEPTION, new Object[] {});
	}
	
	protected AlreadyExistsException(MessageKey key, Object[] args) {
		super(key, args);
	}

}
