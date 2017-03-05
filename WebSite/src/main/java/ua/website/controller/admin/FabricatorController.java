package ua.website.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.website.entity.Fabricator;
import ua.website.service.FabricatorService;
import ua.website.validator.FabricatorValidator;

@Controller
@RequestMapping("/admin/fabricatorModer")
@SessionAttributes("fabricator")
public class FabricatorController {

	@Autowired
	FabricatorService fabricatorService;

	@InitBinder("fabricator")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new FabricatorValidator(fabricatorService));
	}
	
	@ModelAttribute("fabricator")
	public Fabricator getForm() {
		return new Fabricator();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("fabricators", fabricatorService.findAll());
		return "admin-fabricatorModer";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("fabricator", fabricatorService.findOne(id));
		show(model);
		return "admin-fabricatorModer";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		fabricatorService.delete(id);
		return "redirect:/admin/fabricatorModer";
	}

	@PostMapping
	public String save(@ModelAttribute("fabricator")@Valid Fabricator fabricator,
			BindingResult br,Model model, SessionStatus status) {
		if(br.hasErrors()) return show(model);
		
		
		fabricatorService.save(fabricator);
		status.setComplete();

		return "redirect:/admin/fabricatorModer";
	}

}
