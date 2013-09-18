package br.com.viktor.javawebpoc.configuration;

import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.Assert;

import com.jolbox.bonecp.BoneCPDataSource;

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"br.com.viktor.javawebpoc.repository"})
@PropertySource(name = "persistenceProperties", value = "classpath:/${environment:dev}/persistence.properties")
@Configuration
public class PersistenceConfig {

	@Inject
	Environment environment;
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(environment.getProperty("jdbc.driverClassName"));
		dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		String database = environment.getProperty("jdbc.database");
		Assert.hasText(database, "The atribute \"jdbc.database\" in persistence.properties not should be null.");
		Database databaseEnum = Database.valueOf(database);
		vendorAdapter.setDatabase(databaseEnum);
		vendorAdapter.setGenerateDdl(false);
		vendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaProperties(additionalProperties());
		factory.setPackagesToScan("br.com.viktor.javawebpoc.entity");
		factory.setDataSource(dataSource());

		return factory;
	}
	
	private Properties additionalProperties() {
		return new Properties() {
			private static final long serialVersionUID = 7521757852680099194L;
			{
				// Propriedades especificas do hibernate
				setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
				setProperty("hibernate.ejb.naming_strategy", environment.getProperty("hibernate.ejb.naming_strategy"));
				setProperty("hibernate.show_sql", environment.getProperty("hibernate.format_sql"));
				setProperty("hibernate.format_sql", environment.getProperty("hibernate.show_sql"));
				setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
				
			}
		};
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}
}
