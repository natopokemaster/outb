package br.com.clarobr.serviceusagesbroadbands.exception;

public class ForbiddenException extends Exception {

	private static final long serialVersionUID = 1L;

	public ForbiddenException(String msg) {
		super(msg);
	}
}
