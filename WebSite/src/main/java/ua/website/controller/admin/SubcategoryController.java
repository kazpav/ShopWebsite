package ua.website.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.website.dto.filter.SubcategoryFilter;
import ua.website.editor.CategoryEditor;
import ua.website.entity.Category;
import ua.website.entity.Subcategory;
import ua.website.service.CategoryService;
import ua.website.service.SubcategoryService;
import ua.website.util.ParamBuilder;
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
	
	@ModelAttribute("filter")
	public SubcategoryFilter getFilter(){
		return new SubcategoryFilter();
	}
	
	@ModelAttribute("subcategory")
	public Subcategory getForm(){
		return new Subcategory();
	}
	
	
	
	@GetMapping
	public String show(Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") SubcategoryFilter filter){
		model.addAttribute("page", subcategoryService.findAll(pageable,filter));
		model.addAttribute("categories", categoryService.findAll());
		return "admin-subcategModer";
	}
	

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") SubcategoryFilter filter){
		subcategoryService.delete(id);
		return "redirect:/admin/subcategModer"+getParams(pageable,filter);
	}
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") SubcategoryFilter filter){
		model.addAttribute("subcategory", subcategoryService.findOne(id));
		return show(model,pageable,filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("subcategory")@Valid Subcategory subcategory,
			BindingResult br,Model model, SessionStatus status,
			@PageableDefault Pageable pageable, @ModelAttribute("filter") SubcategoryFilter filter){
		if(br.hasErrors()) return show(model,pageable,filter);
		
		subcategoryService.save(subcategory);
		status.setComplete();
		return "redirect:/admin/subcategModer"+getParams(pageable,filter);
	}
	
	private String getParams(Pageable pageable, SubcategoryFilter filter){
		String page =ParamBuilder.getParams(pageable);
		StringBuilder builder = new StringBuilder(page);
		if(!filter.getSearch().isEmpty()){
			builder.append("&search");
			builder.append(filter.getSearch());
		}
		if(!filter.getCategoryId().isEmpty()){
			for (Integer id : filter.getCategoryId()) {
				builder.append("&categoryId=");
				builder.append(id);
			}
		}
		return builder.toString();

	}
	
}
