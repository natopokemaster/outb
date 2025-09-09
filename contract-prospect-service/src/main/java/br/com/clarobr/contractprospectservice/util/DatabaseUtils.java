package br.com.clarobr.contractprospectservice.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUtils {

	@SuppressWarnings("all")
	public static String _OWNER; // NOSCAN

	@SuppressWarnings("all")
	@Value("${application.contract-prospect.owner}")
	public void setOwner(String owner) {
		_OWNER = owner; // NOSCAN
	}

}
