package br.com.viktor.javawebpoc.facade;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.viktor.javawebpoc.entity.Grade;
import br.com.viktor.javawebpoc.facade.base.AbstractCrudFacade;
import br.com.viktor.javawebpoc.service.contract.GradeServiceContract;

@Component
@Transactional
public class GradeFacade extends AbstractCrudFacade<Grade>{

	public GradeFacade(){
		super(null);
	}
	
	@Inject
	public GradeFacade(GradeServiceContract gradeService) {
		super(gradeService);

	}

}
