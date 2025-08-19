package br.com.netservicos.netcrmcore.geral.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe utilitária para datas.
 * </p>
 * <b> Issues: <br>
 * . </b>
 * 
 * @author mauricio.araujo
 * @since 09/11/2009
 * @version 1.0
 */
public final class DateUtils implements Serializable {

	/**
	 * long.
	 */
	private static final long serialVersionUID = -3864914206503188979L;

	/**
	 * Classe de metodos statico não precisar instancia a classe.
	 * 
	 * @since 25/03/2010
	 */
	private DateUtils() {
		super();
	}

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(DateUtils.class.getSimpleName());
	/**
	 * String.
	 */
	private static final String FORMATO_DATA = "dd/MM/yyyy";
	/**
	 * SimpleDateFormat.
	 */
	private static final SimpleDateFormat FORMAT_PT_BR = new SimpleDateFormat(FORMATO_DATA, new Locale("pt", "BR"));

	/**
	 * @param dataInicial
	 *            the dataInicial
	 * @param dataFinal
	 *            the dataFinal
	 * @return Date
	 * @since 10/11/2009
	 * @author mauricio.araujo
	 */
	public static Date dateDiff(final Calendar dataInicial, final Calendar dataFinal) {
		return dateDiff(dataInicial.getTime(), dataFinal.getTime());
	}

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Retorna a data atual no formato passado por parâmetro.
	 * <p>
	 * 
	 * @param pattern
	 * @return String
	 * @since 10/05/2010
	 * @author carlos.pelissari
	 */
	public static String getDataAtual(final String pattern) {
		final Calendar calendar = Calendar.getInstance(new Locale("pt", "BR"));
		final Date dataAtual = calendar.getTime();
		return dateToString(dataAtual, pattern);
	}

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Calcula a diferença de dias.
	 * <p>
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return long
	 * @since 14/01/2010
	 * @author mauricio.araujo
	 */
	public static int calcularDiferencaDias(final Date dataInicial, final Date dataFinal) {
		int result = -1;
		if (dataInicial != null && dataFinal != null) {
			final Date dtFinal = org.apache.commons.lang.time.DateUtils.truncate(dataInicial,
					Calendar.DAY_OF_MONTH);
			final Date dtAtual = org.apache.commons.lang.time.DateUtils.truncate(dataFinal, Calendar.DAY_OF_MONTH);
			final long diferenca = dtAtual.getTime() - dtFinal.getTime();
			/* 1 dia = 86 400 000 milisegundos */
			final long miliseconds = 86400000L;
			result = (int) (diferenca / miliseconds);
		}
		return result;
	}

	/**
	 * @param dataInicial
	 *            the dataInicial
	 * @param dataFinal
	 *            the dataFinal
	 * @return Date
	 * @since 10/11/2009
	 * @author mauricio.araujo
	 */
	public static Date dateDiff(final Date dataInicial, final Date dataFinal) {
		Date data = null;
		if (dataFinal != null && dataInicial != null) {
			data = new Date(dataFinal.getTime() - dataInicial.getTime());
		}
		return data;
	}

	/**
	 * @param initialTimeMillis
	 *            the initialTimeMillis
	 * @param finalTimeMillis
	 *            the finalTimeMillis
	 * @return Date
	 * @since 10/11/2009
	 * @author mauricio.araujo
	 */
	@SuppressWarnings("boxing")
	public static Long dateDiff(final Long initialTimeMillis, final Long finalTimeMillis) {
		Long result = null;
		if (initialTimeMillis != null && finalTimeMillis != null) {
			result = finalTimeMillis - initialTimeMillis;
		}
		return result;
	}

	/**
	 * @param timeMillis
	 *            the timeMillis
	 * @return Date
	 * @since 10/11/2009
	 * @author mauricio.araujo
	 */
	@SuppressWarnings("boxing")
	public static Date toDate(final Long timeMillis) {
		return new Date(timeMillis);
	}

	/**
	 * @param valor
	 *            the valor
	 * @return Date
	 * @since 10/11/2009
	 * @author mauricio.araujo
	 */
	public static Date toDate(final String valor) {
		Date date = null;
		try {
			date = toDate(valor, FORMAT_PT_BR);
		} catch (IllegalArgumentException e) {
			LOGGER.info(e.getMessage() + " O format esperado é: dd/MM/yyyy");
		}
		return date;
	}

	/**
	 * @param valor
	 *            set valor
	 * @param format
	 *            set format
	 * @return Date
	 * @since 10/11/2009
	 * @author mauricio.araujo
	 */
	public static Date toDate(final String valor, final String format) {
		Date date = null;
		try {
			date = toDate(valor, new SimpleDateFormat(format, new Locale("pt", "BR")));
		} catch (IllegalArgumentException e) {
			LOGGER.info(e.getMessage() + " O format esperado é: " + format);
		}
		return date;
	}

	/**
	 * @param valor
	 *            the
	 * @param format
	 *            the
	 * @return Date
	 * @since 10/11/2009
	 * @author mauricio.araujo
	 */
	public static Date toDate(final String valor, final SimpleDateFormat format) {
		Date date = null;
		try {
			date = format.parse(valor);
		} catch (ParseException e) {
			LOGGER.info(valor + " no formato errado.");
		}
		return date;
	}

	/**
	 * @param date
	 *            the
	 * @param pattern
	 *            the
	 * @return String
	 * @since 10/11/2009
	 * @author mauricio.araujo
	 */
	public static String dateToString(final java.util.Date date, final String pattern) {
		final SimpleDateFormat format = new SimpleDateFormat(pattern, new Locale("pt", "BR"));
		return format.format(date);
	}

	/**
	 * @param date
	 *            the
	 * @return String
	 * @since 10/11/2009
	 * @author mauricio.araujo
	 */
	public static String dateToString(final java.util.Date date) {
		String strDate = null;
		if (date != null) {
			strDate = dateToString(date, FORMATO_DATA);
		}
		return strDate;
	}

	/**
	 * @param dayOfWeek
	 *            the
	 * @return Calendar
	 * @since 10/11/2009
	 */
	@SuppressWarnings("boxing")
	public static Calendar toDayOfWeek(final Integer dayOfWeek) {
		final Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		return calendar;
	}

	/**
	 * @param strDate
	 *            the
	 * @param locale
	 *            the
	 * @return String
	 * @since 10/11/2009
	 */
	public static String parseDateFromTo(final String strDate, final String locale) {
		final SimpleDateFormat patternIso = new SimpleDateFormat("yyyy-MM-dd", new Locale("pt", "BR"));
		final SimpleDateFormat formatBr = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
		String result = null;
		Date data = null;
		if ("br".equals(locale)) {
			try {
				data = patternIso.parse(strDate);
				result = formatBr.format(data);
			} catch (ParseException e) {
				LOGGER.info(e.getMessage() + "Data com formato incorreto!");
			}
		} else if ("en".equals(locale)) {
			try {
				data = formatBr.parse(strDate);
				result = patternIso.format(data);
			} catch (ParseException e) {
				LOGGER.info(e.getMessage() + "Data com formato incorreto!");
			}
		}
		return result;
	}

	/**
	 * @param strDate
	 *            the
	 * @param formatFrom
	 *            the
	 * @param formatTo
	 *            the
	 * @return String
	 * @since 10/11/2009
	 */
	public static String parseDateFromTo(final String strDate, final String formatFrom, final String formatTo) {
		final SimpleDateFormat patternFrom = new SimpleDateFormat(formatFrom, new Locale("pt", "BR"));
		final SimpleDateFormat patternTo = new SimpleDateFormat(formatTo, new Locale("pt", "BR"));
		String result = null;
		try {
			final Date date = patternFrom.parse(strDate);
			result = patternTo.format(date);
		} catch (ParseException e) {
			LOGGER.info(e.getMessage() + "Data com formato incorreto!");
		}
		return result;
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 * @since 22/09/2010
	 */
	public static Date converteStringToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			return sdf.parse(date);
		} catch (ParseException e) {		    
		}
		return null;
	}
}
