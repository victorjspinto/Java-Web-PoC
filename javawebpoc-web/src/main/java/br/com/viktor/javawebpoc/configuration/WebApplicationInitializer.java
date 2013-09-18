package br.com.viktor.javawebpoc.configuration;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import br.com.viktor.javawebpoc.filter.OptionsHeadersFilter;

public class WebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {

	private static Logger LOG = LoggerFactory.getLogger(WebApplicationInitializer.class);
	
	private static String DEFAULT_ENV = "dev";
	
	private String environment;
	
	private ResourcePropertySource environmentResource;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		loadEnvironment();
		WebApplicationContext rootContext = createRootContext(servletContext);
		configureSpringMvc(servletContext, rootContext);
	}

	private void loadEnvironment() {
		try {
			environmentResource = new ResourcePropertySource("environmentProperties", "classpath:server.properties"); 
			environment = (String) environmentResource.getProperty("environment");
			if (!StringUtils.hasText(environment)) {
				LOG.info("Environment not informed. Setting default Environment");
				environment = DEFAULT_ENV;
			}
		}catch (IOException ex) {
			LOG.info("didn't find env.properties in classpath");
		}
		
	}

	private WebApplicationContext createRootContext(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(ApplicationConfig.class);
		rootContext.register(PersistenceConfig.class);
		rootContext.getEnvironment().setActiveProfiles(environment);
		rootContext.getEnvironment().getPropertySources().addFirst(environmentResource);
		rootContext.refresh();

		servletContext.addListener(new ContextLoaderListener(rootContext));
		servletContext.setInitParameter("defaultHtmlEscape", "true");

		return rootContext;
	}

	private void configureSpringMvc(ServletContext servletContext, WebApplicationContext rootContext) {
		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(WebConfig.class);
		mvcContext.setParent(rootContext);
		
		ServletRegistration.Dynamic appServlet = servletContext.addServlet("webservice", new DispatcherServlet(mvcContext));
		appServlet.setLoadOnStartup(1);
		Set<String> mappingConflicts = appServlet.addMapping("/rest/*");

		if (!mappingConflicts.isEmpty()) {
			for (String s : mappingConflicts) {
				LOG.error("Mapping conflict: " + s);
			}
			throw new IllegalStateException("'webservice' cannot be mapped to '/'");
		}
		
		servletContext.addFilter("optionsHeaderFilter", new OptionsHeadersFilter());
	}
	
}
