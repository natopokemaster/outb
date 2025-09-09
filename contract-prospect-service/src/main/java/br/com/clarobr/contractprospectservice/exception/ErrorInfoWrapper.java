package br.com.clarobr.contractprospectservice.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfoWrapper {

	@JsonProperty("error")
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
