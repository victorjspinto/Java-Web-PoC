package br.com.viktor.javawebpoc.exception.notFound;

import br.com.viktor.javawebpoc.exception.JavaWebPoCException;
import br.com.viktor.javawebpoc.l10n.MessageKey;

public class NotFoundException extends JavaWebPoCException {
	
	private static final long serialVersionUID = -1529826613361728000L;
	
	public NotFoundException() {
		super(MessageKey.NOTFOUND_EXCEPTION, new Object[] {});
	}

	protected NotFoundException(MessageKey key, Object[] args) {
		super(key, args);
	}

}
