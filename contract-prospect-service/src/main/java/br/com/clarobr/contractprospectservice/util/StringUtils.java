package br.com.clarobr.contractprospectservice.util;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;

@SuppressWarnings("all")
public abstract class StringUtils {

	private StringUtils() {
		throw new IllegalStateException(ContractProspectServiceConstansts.MESSAGE_UTILITY_CLASS);
	}

	/**
	 * Validate is String parameter is null
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNull(String string) {

		if (string != null) {
			return Boolean.FALSE;
		}

		return Boolean.TRUE;

	}

	public static String checkNull(Object param) {
		String value = null;

		if (param != null) {
			value = param.toString();

			if (value.isEmpty()) {
				value = null;
			}

		}

		return value;
	}

	/**
	 * Validate is Object parameter is null
	 * 
	 * @param object
	 * @return
	 */
	public static Boolean isNull(Object object) {

		if (object != null) {
			return Boolean.FALSE;
		}

		return Boolean.TRUE;

	}

	/**
	 * 
	 * Check value in param is null
	 * 
	 * @param param
	 * @return
	 */
	public static String convertFieldValue(Object param) {
		String value = null;

		if (!StringUtils.isNull(param)) {
			value = param.toString();
		}

		return value;
	}

	/**
	 * Validate has only numbers in String parameter
	 * 
	 * @param charSequence
	 * @return
	 */
	public static boolean hasOnlyNumbers(String charSequence) {
		int comprimento = charSequence.length() - 1;

		if (comprimento > 0) {
			return charSequence.matches("^[0-9]+$");
		}

		return false;

	}

	public static Object convertFieldBoolean(String value) {

		if (value.trim().equals(ContractProspectServiceConstansts.DEFAULT_BLANK_VALUE.trim())) {
			return "";
		} else if (value.equalsIgnoreCase(ContractProspectServiceConstansts.DEFAULT_BOOLEAN_VALUE_FALSE)) {
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	public static Object convertNullValue(Object value, Object param) {

		if (isNull(value)) {
			return param;
		}

		return value;
	}

	@SuppressWarnings("all")
	public static String convertStringNullValue(String value, String param) {

		if (isNull(value)) {
			return param;
		} else if (isBlank(value)) {
			return param; // NOSCAN
		}

		return value;
	}

	public static Boolean isBlank(String param) {

		if (isNull(param) || param.trim().length() == 0 || param == "") {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public static String convertNumber(String obtained, String changed) {

		if (isNull(obtained)) {
			return changed;
		}

		String retorno = convertStringNullValue(obtained, changed);

		if (!hasOnlyNumbers(obtained)) {
			return changed;
		}

		return retorno;
	}

}
