package br.com.clarobr.serviceusagesbroadbands.util;

public class Correlation {
	
	private static String correlationId;
	
	private Correlation() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String getCorrelationid() {
		return correlationId;
	}
 
	public static void setCorrelationid(String correlationid) {
		correlationId = correlationid;
	}
}
