package br.com.clarobr.serviceusagesbroadbands.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class TestConfig {

    @Bean(name = "messageResources")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");  // Nome do arquivo de mensagens
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}