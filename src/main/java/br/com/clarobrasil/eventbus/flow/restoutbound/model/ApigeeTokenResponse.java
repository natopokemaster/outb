package br.com.clarobrasil.eventbus.flow.restoutbound.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author Tonny Reis
 * @version 1.0.0
 */

@Data
@ToString
public class ApigeeTokenResponse implements Serializable {

    @JsonProperty("refresh_token_expires_in")
    private String refreshTokenExpiresIn;

    @JsonProperty("api_product_list")
    private String apiProductList;

    @JsonProperty("api_product_list_json")
    private List<String> apiProductListJson;

    @JsonProperty("organization_name")
    private String organizationName;

    @JsonProperty("developer.email")
    private String developerEmail;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("issued_at")
    private Long issuedAt;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("application_name")
    private String applicationName;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("expires_in")
    private Long expiresIn;

    @JsonProperty("refresh_count")
    private String refreshCount;

    @JsonProperty("status")
    private String status;

}
