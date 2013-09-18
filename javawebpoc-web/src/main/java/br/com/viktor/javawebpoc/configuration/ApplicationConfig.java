package br.com.viktor.javawebpoc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"br.com.viktor.javawebpoc.service.impl"})
@Import(value = {PersistenceConfig.class})
public class ApplicationConfig {
	
}
