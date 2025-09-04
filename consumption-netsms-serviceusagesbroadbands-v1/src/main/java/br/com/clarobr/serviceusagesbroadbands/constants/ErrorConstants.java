package br.com.clarobr.serviceusagesbroadbands.constants;

public class ErrorConstants {
    public static final String ERROR_XQUERYSTRING_OUT_OF_STANDARD = "The xquery string informed is out of standard. Please check the documentation out to know the correct way to fill in the fields.";
    public static final String ERROR_REQUIRED_PARAMETERS = "Required some parameters not found: 'customerContractId' or 'smartCardNumber'. It is mandatory to fill only one of the two fields informed.";
    public static final String ERROR_MISSING_CITYID_OPERATORCODE = "For requests that uses 'customerContractId', it is necessary to enter the 'cityId' or 'operatorCode'. It is mandatory to fill only one of the two fields informed.";
    public static final String ERROR_INVALID_FORMAT_DATE = "The date field format provided is invalid. Only numbers are allowed. Please check the documentation for the correct format.";
    public static final String ERROR_MANDATORY_PARAMETERS = "Required parameters not found: 'addressableCode', 'startDate', 'endDate', or the boolean flag 'detailed'. It is mandatory to fill all of the fields informed.";
    public static final String ERROR_END_DATE_EARLIER_START_DATE = "The endDate field contains a date earlier than the startDate. Please enter an endDate later than the startDate.";
    public static final String ERROR_CITYID_NOT_FOUND = "CityID not found. The query did not return any CityID for the provided OperatorCode.";
    public static final String ERROR_DATA_NOT_FOUND = "Customer data not found. The customer information could not be retrieved from database.";
    public static final String API_SERVICEUSAGESBROADBANDS_001 = "API-SERVICEUSAGESBROADBANDS-001";
    public static final String API_SERVICEUSAGESBROADBANDS_002 = "API-SERVICEUSAGESBROADBANDS-002";

    private ErrorConstants() {
        throw new IllegalStateException("Utility class");
    }
}
