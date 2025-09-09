package br.com.clarobr.contractprospectservice.exception;

public class UnavailableForLegalReasonsException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public UnavailableForLegalReasonsException(String msg) {
		super(msg);
	}
}
