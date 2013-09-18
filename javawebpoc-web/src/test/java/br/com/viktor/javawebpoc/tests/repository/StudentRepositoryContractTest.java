package br.com.viktor.javawebpoc.tests.repository;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.viktor.javawebpoc.configuration.PersistenceConfig;
import br.com.viktor.javawebpoc.repository.StudentRepositoryContract;
import br.com.viktor.javawebpoc.tests.configuration.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, TestConfig.class })
public class StudentRepositoryContractTest {

	@Inject
	private StudentRepositoryContract repository;

	@Test
	public void repositorioNaoDeveSerNulo() {
		Assert.assertNotNull(repository);
	}
	
	@Test
	public void quandoPesquisarPeloNome_deveRetornarPreenchidoSeExistirIgualNoBanco() {
		
		Assert.assertEquals(1, repository.findByName("Leonardo"));
	}

}
