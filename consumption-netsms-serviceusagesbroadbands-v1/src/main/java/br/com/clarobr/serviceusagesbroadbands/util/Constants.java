package br.com.clarobr.serviceusagesbroadbands.util;

public class Constants {
  public static final String X_HEADER_CORRELATION_ID = "X-Correlation-Id"; // Id de transação - Parceiro
  public static final String X_HEADER_TRANSACTION_ID = "X-TransactionId"; // Id da transação APIGEE

  // METHOD EXECUTION
  public static final String KEY_FIELD_CORRELATION_ID = "correlationId";

  private Constants() {
    throw new IllegalStateException("Utility class");
  }
}