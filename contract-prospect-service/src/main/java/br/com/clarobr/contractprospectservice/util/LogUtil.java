package br.com.clarobr.contractprospectservice.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

public final class LogUtil {

	private static final String REGEX = "(\r\n|\n)";

	private LogUtil() {
		throw new IllegalArgumentException("This is a utility class.");
	}

	public static void info(final Logger logger, final String format, Object... pArguments) {

		if (logger.isInfoEnabled()) {
			for (final Object object : pArguments) {
				var element = object;
				if (object instanceof String) {
					logger.info(format, String.valueOf(element).replaceAll(REGEX, ""));
				}
			}
		}
	}

	public static void debug(final Logger logger, String format, Object... pArguments) {
		if (logger.isDebugEnabled()) {
			final Object[] normalizedArgs = normalizeArguments(pArguments);
			logger.debug(format, String.valueOf(normalizedArgs).replaceAll(REGEX, ""));
		}
	}

	public static void error(final Logger logger, String format, Object... pArguments) {
		if (logger.isErrorEnabled()) {
			final Object[] normalizedArgs = normalizeArguments(pArguments);
			logger.error(format, normalizedArgs);
		}
	}

	public static void error(final Logger logger, String format, String arg) {
		if (logger.isErrorEnabled()) {
			final String msg = normalizeArguments(arg);
			logger.error(format, msg);
		}
	}

	public static void error(final Logger logger, String pMsg, Throwable t) {
		if (logger.isErrorEnabled()) {
			final String msg = normalizeArguments(pMsg);
			logger.error(msg, t);
		}
	}

	private static String normalizeArguments(final String pMsg) {
		return pMsg.replaceAll(REGEX, "");
	}

	private static Object[] normalizeArguments(Object... pArguments) {
		final List<Object> arguments = new ArrayList<>();
		for (final Object object : pArguments) {
			var element = object;
			if (object instanceof String) {
				element = String.valueOf(element).replaceAll(REGEX, "");
			}
			arguments.add(element);
		}
		return arguments.toArray();
	}

}
