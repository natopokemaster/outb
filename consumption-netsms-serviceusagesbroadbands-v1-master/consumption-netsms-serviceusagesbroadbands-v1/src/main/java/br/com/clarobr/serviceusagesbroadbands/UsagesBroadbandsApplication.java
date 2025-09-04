package br.com.clarobr.serviceusagesbroadbands;

import br.com.clarobr.common.base.filters.CorrelationHeaderFilter;
import br.com.clarobr.common.base.filters.ResponseFilter;
import br.com.clarobr.common.connection.MultiBaseDataSource;
import org.springframework.aot.generate.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Arrays;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class })
@ComponentScan(basePackages={"br.com.clarobr","br.com.clarobr.common.base"})
@Generated
public class UsagesBroadbandsApplication extends MultiBaseDataSource {

	public static void main(String[] args) {
		SpringApplication.run(UsagesBroadbandsApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<CorrelationHeaderFilter> correlationHeaderFilter() {
		FilterRegistrationBean<CorrelationHeaderFilter> filterRegBean = new FilterRegistrationBean<>();
		filterRegBean.setFilter(new CorrelationHeaderFilter());
		filterRegBean.setOrder(1);
		filterRegBean.setUrlPatterns(Arrays.asList("/*"));
		return filterRegBean;
	}

	@Bean
	public FilterRegistrationBean<ResponseFilter> responseFilter() {
		final FilterRegistrationBean<ResponseFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new ResponseFilter());
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}

	@Bean(name = "messageResources")
	MessageSource messagesResources() {
		var messageBundleResrc = new ResourceBundleMessageSource();
		messageBundleResrc.setDefaultEncoding("UTF-8");
		return messageBundleResrc;
	}
}
