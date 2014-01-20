package br.com.viktor.javawebpoc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.viktor.javawebpoc.entity.Student;
import br.com.viktor.javawebpoc.facade.base.AbstractCrudFacade;
import br.com.viktor.javawebpoc.service.contract.base.AbstractCrudContract;

@Component
@Transactional
public class StudentFacade extends AbstractCrudFacade<Student> {

	@Autowired
	public StudentFacade(AbstractCrudContract<Student> abstractCrud) {
		super(abstractCrud);
	}

}