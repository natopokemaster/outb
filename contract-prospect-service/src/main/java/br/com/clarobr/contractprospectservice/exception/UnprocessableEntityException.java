package br.com.clarobr.contractprospectservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("all")
	private String parameterName;

	public UnprocessableEntityException(String message) {
		super(message);
	}

	public UnprocessableEntityException(String message, String parameterName) {
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