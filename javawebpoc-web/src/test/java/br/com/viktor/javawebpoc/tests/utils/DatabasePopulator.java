package br.com.viktor.javawebpoc.tests.utils;

import javax.sql.DataSource;

import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.util.Assert;

public class DatabasePopulator {
	
	public static void populate(Resource resource, DataSource dataSource) {
		Assert.notNull(resource);
		Assert.notNull(dataSource);
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(resource);
		DatabasePopulatorUtils.execute(populator, dataSource);
	}

}
