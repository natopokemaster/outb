package br.com.clarobr.contractprospectservice.exception;

public class ForbiddenException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public ForbiddenException(String msg) {
		super(msg);
	}
}
