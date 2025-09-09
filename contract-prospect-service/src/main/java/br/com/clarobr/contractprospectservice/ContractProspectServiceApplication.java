package br.com.clarobr.contractprospectservice;

import java.util.Arrays;
import java.util.TimeZone;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import br.com.clarobr.contractprospectservice.correlation.CorrelationHeaderFilter;

@SpringBootApplication
@Slf4j
@ComponentScan({"br.com.clarobr"})
@EnableTransactionManagement
@EnableCaching
@EnableJpaRepositories(basePackages = "br.com.clarobr.contractprospectservice.repository")
public class ContractProspectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractProspectServiceApplication.class, args);
	}

	static {
		System.setProperty("oracle.jdbc.timezoneAsRegion", "false");
		final TimeZone timeZone = TimeZone.getTimeZone("America/Sao_Paulo");
		TimeZone.setDefault(timeZone);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public FilterRegistrationBean<CorrelationHeaderFilter> correlationHeaderFilter() {
		FilterRegistrationBean<CorrelationHeaderFilter> filterRegBean = new FilterRegistrationBean<>();
		filterRegBean.setFilter(new CorrelationHeaderFilter());
		filterRegBean.setUrlPatterns(Arrays.asList("/*"));
		return filterRegBean;
	}
}