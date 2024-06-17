package net.comece.smtpmailcomece.config;

import net.comece.smtpmailcomece.filter.DatabaseHealthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DatabaseHealthFilter> loggingFilter() {
        FilterRegistrationBean<DatabaseHealthFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new DatabaseHealthFilter());
        registrationBean.addUrlPatterns("/api/v1/send-email");

        return registrationBean;
    }
}
