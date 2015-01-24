package io.github.lordviktor.javawebpoc.core.exception.alreadyExists;

import io.github.lordviktor.javawebpoc.core.exception.JavaWebPoCException;
import io.github.lordviktor.javawebpoc.core.l10n.MessageKey;

public class AlreadyExistsException extends JavaWebPoCException {

	private static final long serialVersionUID = 1L;

	public AlreadyExistsException() {
		super(MessageKey.ALREADYEXISTS_EXCEPTION, new Object[] {});
	}
	
	protected AlreadyExistsException(MessageKey key, Object[] args) {
		super(key, args);
	}

}
