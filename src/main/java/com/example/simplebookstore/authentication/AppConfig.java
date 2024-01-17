package com.example.simplebookstore.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final ApiKeyService apiKeyService;

    @Autowired
    public AppConfig(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }
    @Bean
    public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter() {
        FilterRegistrationBean<ApiKeyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ApiKeyFilter(apiKeyService));
        registrationBean.addUrlPatterns("/v1/*"); // TO make any endpoint accessible without the key, add it here
        return registrationBean;
    }
}
