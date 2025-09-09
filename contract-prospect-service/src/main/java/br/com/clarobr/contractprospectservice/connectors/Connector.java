package br.com.clarobr.contractprospectservice.connectors;

import java.util.Base64;
import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public abstract class Connector {

	protected HttpEntity<String> addHttpHeaders(HashMap<String, String> headers) {
		var httpHeaders = new HttpHeaders();
		headers.forEach(httpHeaders::add);
		return new HttpEntity<>(httpHeaders);
	}

	protected HttpEntity<String> convertHeaderstoHttpEntity(HttpHeaders headers) {
		return new HttpEntity<>(headers);
	}

	protected HttpHeaders createHeaders(String username, String password) {
		var auth = username + ":" + password;
		var encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

		var headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + encodedAuth);
		return headers;
	}

	protected HttpHeaders createHeadersEnconder(String encodedAuth) {

		var headers = new HttpHeaders();

		headers.add("Authorization", "Basic " + encodedAuth);
		return headers;
	}
}