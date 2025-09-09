package br.com.clarobr.contractprospectservice.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class ErrorInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("timestamp")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private String timestamp;

	@JsonProperty("httpCode")
	private int httpCode;

	@JsonProperty("errorCode")
	private String errorCode;

	@JsonProperty("message")
	private String message;

	@JsonProperty("detailedMessage")
	private String detailedMessage;

	@JsonProperty("path")
	private String path;

	public ErrorInfo(String timestamp, int httpCode, String errorCode, String message, String detailedMessage,
			String path) {
		super();
		this.timestamp = timestamp;
		this.httpCode = httpCode;
		this.errorCode = errorCode;
		this.message = message;
		this.detailedMessage = detailedMessage;
		this.path = path;
	}

	public ErrorInfo() {

	}

	public String getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public int getHttpCode() {
		return this.httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetailedMessage() {
		return this.detailedMessage;
	}

	public void setDetailedMessage(String detailedMessage) {
		this.detailedMessage = detailedMessage;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}