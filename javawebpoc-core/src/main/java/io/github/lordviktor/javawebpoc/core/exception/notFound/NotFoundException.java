package io.github.lordviktor.javawebpoc.core.exception.notFound;

import io.github.lordviktor.javawebpoc.core.exception.JavaWebPoCException;
import io.github.lordviktor.javawebpoc.core.l10n.MessageKey;

public class NotFoundException extends JavaWebPoCException {
	
	private static final long serialVersionUID = -1529826613361728000L;
	
	public NotFoundException() {
		super(MessageKey.NOTFOUND_EXCEPTION, new Object[] {});
	}

	protected NotFoundException(MessageKey key, Object[] args) {
		super(key, args);
	}

}
