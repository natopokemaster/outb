package br.com.netservicos.netcrmcore.cliente.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator {
	
	public static final String FORMATO_CURTO = "dd/MM/yyyy";
	public static final String FORMATO_LONGO = "dd/MM/yyyy HH:mm:ss";
	
	public static boolean isValid(String value, String datePattern) {
		if (value == null || datePattern == null || datePattern.length() <= 0){
			return false;
		}
		if(datePattern.length() != value.length()){
			return false;
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
		formatter.setLenient(false);
		try {
			formatter.parse(value);
		} catch (ParseException e) {
			return false;
		}
        return true;
	}
}
