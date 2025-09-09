package br.com.clarobr.contractprospectservice.exception;

public class CircuitBreakerException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4476976380953547723L;

	public CircuitBreakerException(String message) {
		super(message);
	}

	public CircuitBreakerException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

}
