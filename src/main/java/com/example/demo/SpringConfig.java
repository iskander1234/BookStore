package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
@PropertySource("application.properties")
//@EnableJpaRepositories(basePackages = "com.example.demo")
public class SpringConfig {
}

