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

import ua.website.editor.CategoryEditor;
import ua.website.entity.Category;
import ua.website.entity.Subcategory;
import ua.website.service.CategoryService;
import ua.website.service.SubcategoryService;
import ua.website.validator.SubcategoryValidator;


@Controller
@RequestMapping("/admin/subcategModer")
@SessionAttributes("subcategory")
public class SubcategoryController {

	
	@Autowired
	SubcategoryService subcategoryService;
	@Autowired
	CategoryService categoryService;
	
	
	@InitBinder("subcategory")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.setValidator(new SubcategoryValidator(subcategoryService));
	}
	
	@ModelAttribute("subcategory")
	public Subcategory getForm(){
		return new Subcategory();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("subcategories", subcategoryService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return "admin-subcategModer";
	}
	

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		subcategoryService.delete(id);
		return "redirect:/admin/subcategModer";
	}
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("subcategory", subcategoryService.findOne(id));
		return show(model);
	}
	
	@PostMapping
	public String save(@ModelAttribute("subcategory")@Valid Subcategory subcategory,
			BindingResult br,Model model, SessionStatus status){
		if(br.hasErrors()) return show(model);
		
		subcategoryService.save(subcategory);
		status.setComplete();
		return "redirect:/admin/subcategModer";
	}

}
