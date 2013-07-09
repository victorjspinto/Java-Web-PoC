package br.com.viktor.javawebpoc.controller.base;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.viktor.javawebpoc.entity.base.AbstractEntity;
import br.com.viktor.javawebpoc.service.contract.EntityNotExistException;
import br.com.viktor.javawebpoc.service.contract.base.AbstractCrudContract;

public class AbstractCrudController<T extends AbstractEntity> {

	protected AbstractCrudContract<T> service;

	public AbstractCrudController(AbstractCrudContract<T> service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<T> list() {
		return service.list();
	}

	@RequestMapping(value = "/find/{id}")
	@ResponseBody
	public T find(@PathVariable("id") long id) throws EntityNotExistException {
		return service.find(id);
	}

	@RequestMapping(value = "/save")
	public void save(Model model) {
		model.addAttribute("list", service.list());
	}
}
