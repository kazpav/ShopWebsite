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

import ua.website.dto.filter.SimpleFilter;
import ua.website.entity.Category;
import ua.website.service.CategoryService;
import ua.website.validator.CategoryValidator;

import static ua.website.util.ParamBuilder.*;

/**
 * Controller that will be called on {/admin/categoryModer} link;
 * makes CRUD operations and manipulations with {@Category} Entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Category
 * @see ua.website.service.CategoryService
 * @see ua.website.validator.CategoryValidator
 * @see ua.website.dto.filter.SimpleFilter
 */
@Controller
@RequestMapping("/admin/categoryModer")
@SessionAttributes("category")
public class CategoryController {

	/** Injected {@code CategoryService} used in this Controller*/
	@Autowired
	private CategoryService categoryService;

	/** Binds validator for {@Category} objects */
	@InitBinder("category")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new CategoryValidator(categoryService));
	}

	/**
	 * Creates and returns new empty {@code Category} object
	 * @return new empty {@code Category} object
	 */
	@ModelAttribute("category")
	public Category getForm() {
		return new Category();
	}

	/**
	 * Creates and returns new empty {@code SimpleFilter} object
	 * @return new empty {@code SimpleFilter} object
	 */
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}

	/**
	 * This method gets all {@code Categories} in DataBase in Pageable perspective
	 * @param model model we use
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("page", categoryService.findAll(filter,pageable));
		model.addAttribute("categories", categoryService.findAll());
		return "admin-categoryModer";
	}

	/**
	 * This method updates specified {@code Category} using Get request
	 * on {/admin/categoryModer/update/[id]} link
	 * @param id id of {@code Category} we want to update
	 * @param model model we use
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("category", categoryService.findOne(id));
		show(model,pageable,filter);
		return "admin-categoryModer";
	}

	/**
	 * This method deletes specified {@code Category} using Get request
	 * on {/admin/categoryModer/delete/[id]} link
	 * @param id id of {@code Category} we want to delete
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		categoryService.delete(id);
		return "redirect:/admin/categoryModer"+getParams(pageable,filter);
	}

	/**
	 * This method saves new {@code Category} to database
	 * using Post method
	 * @param category {@code Category} to save
	 * @param br {@code BindingResult} object to check for any validation errors
	 * @param model model we use
	 * @param status {@code SessionStatus} to manipulate current session
	 * @param pageable pagination settings
	 * @param filter {@SimpleFilter} filtering settings
	 * @return link for redirection
	 */
	@PostMapping
	public String save(@ModelAttribute("category")@Valid Category category,
			BindingResult br, Model model, SessionStatus status, 
			@PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		if(br.hasErrors()) return show(model,pageable,filter);
		categoryService.save(category);
		status.setComplete();
		return "redirect:/admin/categoryModer"+getParams(pageable,filter);
	}
}
