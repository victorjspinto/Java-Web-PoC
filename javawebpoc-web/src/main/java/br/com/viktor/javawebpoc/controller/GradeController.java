package br.com.viktor.javawebpoc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.viktor.javawebpoc.controller.base.AbstractCrudController;
import br.com.viktor.javawebpoc.entity.Grade;
import br.com.viktor.javawebpoc.facade.GradeFacade;

@Controller
@RequestMapping("/grade")
public class GradeController extends AbstractCrudController<Grade> {

	@Inject
	public GradeController(GradeFacade gradeFacade) {
		super(gradeFacade);
	}

}
