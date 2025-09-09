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
public class ErrorResponse {
    @JsonProperty("error")
    public ErrorUtil error;

    public ErrorResponse(ErrorUtil error) {
        this.error = error;
    }

    public ErrorResponse() {
    }
}

