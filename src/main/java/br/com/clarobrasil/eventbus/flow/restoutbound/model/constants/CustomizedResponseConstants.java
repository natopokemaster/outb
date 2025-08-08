package br.com.clarobrasil.eventbus.flow.restoutbound.model.constants;

/**
 * @author Tonny Reis
 * @version 1.0.0
 */

public class CustomizedResponseConstants {

    private CustomizedResponseConstants(){
        throw new IllegalStateException("Utility class");
    }

    public static final String ERROR_API_CODE = "WORKER-OUTBOUND-";
    public static final String ERROR_API_CODE_INTERNAL = "500";
    public static final String ERROR_APIGEE = "Error in request APIGEE: ";
    public static final String ERROR_WORKER_RETRY = "message considered as error after maximum attempts";
    public static final String ERROR_WORKER_MESSAGE_CONVERTER = "error while trying to convert received message to error message";

}
