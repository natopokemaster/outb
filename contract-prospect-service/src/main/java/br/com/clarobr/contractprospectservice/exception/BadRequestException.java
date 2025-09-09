package br.com.clarobr.contractprospectservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("all")
	private String parameterName; // NOSCAN

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	public BadRequestException(String message, String parameterName) {
		super(message);
		this.parameterName = parameterName;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

}