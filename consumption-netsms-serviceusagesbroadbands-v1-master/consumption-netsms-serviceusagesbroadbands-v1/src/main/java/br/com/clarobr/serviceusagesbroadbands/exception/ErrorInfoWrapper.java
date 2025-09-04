package br.com.clarobr.serviceusagesbroadbands.exception;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class ErrorInfoWrapper {

	@JsonUnwrapped
	private ErrorInfo error;

	/**
	 * @return the error
	 */
	public final ErrorInfo getError() {
		return this.error;
	}

	/**
	 * @param pError the error to set
	 */
	public final void setError(ErrorInfo pError) {
		this.error = pError;
	}

}
