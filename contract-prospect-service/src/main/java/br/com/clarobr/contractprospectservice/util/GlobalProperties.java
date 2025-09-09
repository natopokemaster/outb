package br.com.clarobr.contractprospectservice.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties // no prefix, root level.
public class GlobalProperties {

	// From k8s ConfigMap
	private String serviceorderingsHitcommandsHost;

	// From k8s ConfigMap
	private String serviceorderingsHitcommandsPath;

	// From k8s Secret
	private String serviceorderingsHitcommandsUser;

	// From k8s Secret
	private String serviceorderingsHitcommandsPassword;

	// From k8s Secret
	private String serviceorderingsHitcommandsEncodedAuth;
}
