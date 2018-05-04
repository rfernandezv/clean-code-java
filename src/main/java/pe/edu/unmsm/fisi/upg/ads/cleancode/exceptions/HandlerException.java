package pe.edu.unmsm.fisi.upg.ads.cleancode.exceptions;

import java.io.Serializable;

public class HandlerException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public HandlerException(String message) {
		super(message);
	}

	public HandlerException(String format, Object[] args) {
		super(String.format(format, args));
	}
}