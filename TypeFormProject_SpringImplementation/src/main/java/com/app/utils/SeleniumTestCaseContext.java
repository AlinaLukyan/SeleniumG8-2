package com.app.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackageClasses = SeleniumTestCaseContext.class)
public class SeleniumTestCaseContext {

    @Bean
    public TestScope testScope() {
        return new TestScope();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer scopeConfigurator = new CustomScopeConfigurer();
        Map<String, Object> scopes = new HashMap<>();
        scopes.put("test", testScope());
        scopeConfigurator.setScopes(scopes);
        return scopeConfigurator;
    }

    @Bean
    @Scope("test")
    public WebDriver webDriver() {
        return new FirefoxDriver();
    }
}