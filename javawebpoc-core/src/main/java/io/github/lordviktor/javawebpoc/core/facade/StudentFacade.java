package io.github.lordviktor.javawebpoc.core.facade;

import io.github.lordviktor.javawebpoc.core.facade.base.AbstractCrudFacade;
import io.github.lordviktor.javawebpoc.core.service.base.AbstractCrudService;
import io.github.lordviktor.javawebpoc.persistence.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class StudentFacade extends AbstractCrudFacade<Student> {

	@Autowired
	public StudentFacade(AbstractCrudService<Student> abstractCrud) {
		super(abstractCrud);
	}

}