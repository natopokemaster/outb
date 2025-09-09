package br.com.clarobr.contractprospectservice.exception;

public class ConflictException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public ConflictException(String msg) {
		super(msg);
	}
}
