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

import ua.website.entity.Category;
import ua.website.service.CategoryService;
import ua.website.validator.CategoryValidator;

@Controller
@RequestMapping("/admin/categoryModer")
@SessionAttributes("category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@InitBinder("category")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new CategoryValidator(categoryService));
	}
	
	
	@ModelAttribute("category")
	public Category getForm() {
		return new Category();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "admin-categoryModer";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("category", categoryService.findOne(id));
		show(model);
		return "admin-categoryModer";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		categoryService.delete(id);
		return "redirect:/admin/categoryModer";
	}

	@PostMapping
	public String save(@ModelAttribute("category")@Valid Category category,
			BindingResult br, Model model, SessionStatus status) {
		if(br.hasErrors()) return show(model);
		
		
		categoryService.save(category);
		status.setComplete();

		return "redirect:/admin/categoryModer";
	}
}
