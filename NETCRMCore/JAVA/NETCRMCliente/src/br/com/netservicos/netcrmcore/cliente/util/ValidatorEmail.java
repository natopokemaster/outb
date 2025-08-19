package br.com.netservicos.netcrmcore.cliente.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Validador de e-mail adaptado no framework apache validator
 */
public class ValidatorEmail {
	private static Matcher matcher = null;
	private static Pattern pattern = null;

	public static boolean isValid(String email) {
		if (email == null){
			return false;
		}
		pattern = Pattern.compile("^[\\\000-\\\177]+$");
		matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			return false;
		}

		pattern = Pattern.compile("^(.+)@(.+)$");
		matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			return false;
		}
		if (email.endsWith(".")){
			return false;
		}
		String grupo1 = matcher.group(1);
		String grupo2 = matcher.group(2);
		if (!isValidUser(grupo1)){
			return false;
		}
		return isValidDomain(grupo2);
	}

	protected static boolean isValidDomain(String domain) {
		pattern = Pattern
				.compile("^(\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})$");
		matcher = pattern.matcher(domain);
		if (matcher.matches()) {
			if (!isValidIpAddress(matcher)){
				return false;
			}
		} else {
			pattern = Pattern
			.compile("([a-zA-Z0-9-_\\.]+)");
			matcher = pattern.matcher(domain);
			matcher = pattern.matcher(domain);
			if(matcher.matches()){
				return true;
			}
			return false;
		}
		return false;
	}

	protected static boolean isValidUser(String user) {
		pattern = Pattern
		.compile("([a-zA-Z0-9-_\\.]+)");
		matcher = pattern.matcher(user);
		return matcher.matches();
	}

	protected static boolean isValidIpAddress(Matcher ipAddressMatcher) {
		for (int i = 1; i <= 4; i++) {
			String ipSegment = ipAddressMatcher.group(i);
			if (ipSegment == null || ipSegment.length() <= 0){
				return false;
			}
			int iIpSegment = 0;
			try {
				iIpSegment = Integer.parseInt(ipSegment);
			} catch (NumberFormatException e) {
				return false;
			}
			if (iIpSegment > 255){
				return false;
			}
		}

		return true;
	}
}
