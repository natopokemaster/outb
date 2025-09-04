package br.com.clarobr.serviceusagesbroadbands.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "httpCode", "errorCode", "message", "detailedMessage", "link" })
@Data
@NoArgsConstructor
public class ErrorInfo implements Serializable {
	@Serial
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

	@JsonProperty("link")
	private Link link;

	public ErrorInfo(int httpCode, String errorCode, String message, String detailedMessage, Link link) {
		super();
		this.httpCode = httpCode;
		this.errorCode = errorCode;
		this.message = message;
		this.detailedMessage = detailedMessage;
		this.link = link;
	}

}