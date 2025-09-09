package br.com.clarobr.contractprospectservice.exception;

public class TooManyRequestsException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public TooManyRequestsException(String msg) {
		super(msg);
	}
}
