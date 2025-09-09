package br.com.clarobr.contractprospectservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("all")
	private String parameterName;

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String message, String parameterName) {
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