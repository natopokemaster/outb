package br.com.clarobr.serviceusagesbroadbands.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

  private static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
  private static final String DATE_FORMAT_DD_MM_YYYY = "dd/MM/yyyy";
  private DateUtils() {
    throw new IllegalStateException("Utility class.");
  }
  public static boolean isValidDate(String date) {
    return isValidFormat(date, DATE_FORMAT_YYYY_MM_DD);
  }

  // validar a data em qualquer formato
  private static boolean isValidFormat(String date, String format) {
    var sdf = new SimpleDateFormat(format);
    sdf.setLenient(false);
    try {
      sdf.parse(date);
      return true;
    } catch (ParseException e) {
      return false;
    }
  }

  // Converte a data de yyyy-MM-dd para dd/MM/yyyy
  public static String convertToDDMMYYYY(String date) throws ParseException {
    var simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
    var outputFormat = new SimpleDateFormat(DATE_FORMAT_DD_MM_YYYY);
    return outputFormat.format(simpleDateFormat.parse(date));
  }

  // retorna a data de 30 dias atrás a partir de uma data específica ou da data atual
  public static String getLast30Days(LocalDate referenceDate) {

    LocalDate thirtyDaysAgo;
    if (referenceDate != null) {
      thirtyDaysAgo = referenceDate.minusDays(30);
    } else {
      thirtyDaysAgo = LocalDate.now().minusDays(30);
    }

    return thirtyDaysAgo.format(DateTimeFormatter.ofPattern(DATE_FORMAT_YYYY_MM_DD));
  }


}
