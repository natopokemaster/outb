package br.com.clarobr.serviceusagesbroadbands.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("springContextHolder")
public class SpringContextHolder implements ApplicationContextAware
{
    private static ApplicationContext context;

    @Override
    public synchronized void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        context = applicationContext;
    }

    public static synchronized ApplicationContext getApplicationContext()
    {
        if (context == null) {
            throw new IllegalStateException("SpringContextHolder is not ready.");
        }
        return context;
    }

    public static <T> T getBean(Class<T> type)
    {
        return getApplicationContext().getBean(type);
    }

    public static <T> T getBean(String name, Class<T> type)
    {
        return getApplicationContext().getBean(name, type);
    }
}
