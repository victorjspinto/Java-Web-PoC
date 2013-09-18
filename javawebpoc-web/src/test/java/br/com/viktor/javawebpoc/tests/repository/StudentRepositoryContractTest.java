package br.com.viktor.javawebpoc.tests.repository;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.viktor.javawebpoc.configuration.PersistenceConfig;
import br.com.viktor.javawebpoc.repository.StudentRepositoryContract;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class })
public class StudentRepositoryContractTest {
	
	@Inject
	private StudentRepositoryContract repository;
	
	@Test
	public void repositorioNaoDeveSerNulo() {
		Assert.assertNotNull(repository);
	}

}
