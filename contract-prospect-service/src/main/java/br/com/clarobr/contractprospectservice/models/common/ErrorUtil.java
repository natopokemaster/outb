package br.com.clarobr.contractprospectservice.models.common;

/**
 * @author Alan Ricardo
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
public class ErrorUtil {
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("httpCode")
    private String httpCode;
    @JsonProperty("message")
    private String message;
    @JsonProperty("detailedMessage")
    private String detailedMessage;
    @JsonProperty("path")
    private String path;
}

