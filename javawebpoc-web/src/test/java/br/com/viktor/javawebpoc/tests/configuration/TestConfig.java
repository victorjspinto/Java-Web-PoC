package br.com.viktor.javawebpoc.tests.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(name = "environmentProperties", value = "classpath:/test/persistence.properties")
public class TestConfig {

}
