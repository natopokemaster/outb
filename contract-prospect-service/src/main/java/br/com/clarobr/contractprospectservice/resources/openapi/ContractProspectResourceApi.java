package br.com.clarobr.contractprospectservice.resources.openapi;

import br.com.clarobr.contractprospectservice.exception.ErrorInfo;
import br.com.clarobr.contractprospectservice.models.common.CustomHttpEntity;
import br.com.clarobr.contractprospectservice.models.output.ContractProspectOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author Almeida
 */
@Api(tags = { "prospects" })
@SuppressWarnings("all")
public interface ContractProspectResourceApi {
	

	@ApiOperation(value = "Generate interactions")
	@ApiResponses({
		 @ApiResponse(code = 200, message = "Successful OperationRepository"),
         @ApiResponse(code = 400, message = "Bad Request", response = ErrorInfo.class),
		 @ApiResponse(code = 401, message = "Unauthorized", response = ErrorInfo.class),
		 @ApiResponse(code = 403, message = "Forbidden", response = ErrorInfo.class),
		 @ApiResponse(code = 404, message = "Not found", response = ErrorInfo.class),
		 @ApiResponse(code = 405, message = "Method Not Allowed", response = ErrorInfo.class),
		 @ApiResponse(code = 406, message = "Not Acceptable", response = ErrorInfo.class),
		 @ApiResponse(code = 415, message = "Unsupported Media Type", response = ErrorInfo.class),
		 @ApiResponse(code = 429, message = "Too Many Requests", response = ErrorInfo.class),
		 @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorInfo.class),
		 @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorInfo.class),
    })
	public ResponseEntity<CustomHttpEntity<ContractProspectOutput>> getContractProspects(@RequestHeader HttpHeaders httpHeaders) throws Exception;
	

}
