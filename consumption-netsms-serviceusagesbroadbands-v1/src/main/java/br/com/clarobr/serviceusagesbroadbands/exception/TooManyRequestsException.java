package br.com.clarobr.serviceusagesbroadbands.exception;

public class TooManyRequestsException extends Exception {

	private static final long serialVersionUID = 1L;

	public TooManyRequestsException(String msg) {
		super(msg);
	}
}
