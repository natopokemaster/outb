package br.com.clarobr.contractprospectservice.exception;

public class BusinessException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 4550988206013505367L;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

}
