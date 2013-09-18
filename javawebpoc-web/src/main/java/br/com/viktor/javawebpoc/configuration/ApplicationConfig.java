package br.com.viktor.javawebpoc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"br.com.viktor.javawebpoc.service.impl"})
public class ApplicationConfig {
	
}
