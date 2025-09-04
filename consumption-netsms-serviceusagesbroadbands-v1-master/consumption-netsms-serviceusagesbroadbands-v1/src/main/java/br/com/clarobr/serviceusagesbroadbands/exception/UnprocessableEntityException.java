package br.com.clarobr.serviceusagesbroadbands.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
@SuppressWarnings("all")
public class UnprocessableEntityException extends Exception {

	private static final long serialVersionUID = 1L;
	private String parameterName;
	private String errorCode;

	public UnprocessableEntityException(String message) {
		super(message);
	}

	public UnprocessableEntityException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public UnprocessableEntityException(String errorCode, String message, String parameterName) {
		super(message);
		this.errorCode = errorCode;
		this.parameterName = parameterName;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
}
