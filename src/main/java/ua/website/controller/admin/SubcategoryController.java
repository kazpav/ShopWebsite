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

/**
 * Controller that will be called on {/admin/subcategModer} link;
 * makes CRUD operations and manipulations with {@Subcategory} Entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Subcategory
 * @see ua.website.service.SubcategoryService
 * @see ua.website.service.CategoryService
 * @see ua.website.validator.SubcategoryValidator
 * @see ua.website.dto.filter.SubcategoryFilter
 * @see ua.website.editor.CategoryEditor
 */
@Controller
@RequestMapping("/admin/subcategModer")
@SessionAttributes("subcategory")
public class SubcategoryController {

	/** Injected {@code SubcategoryService} used in this Controller*/
	@Autowired
	SubcategoryService subcategoryService;

	/** Injected {@code CategoryService} used in this Controller*/
	@Autowired
	CategoryService categoryService;

	/**
	 * Binds editors for related Entities and validator for {@code Subcategory} objects
	 * @param binder used binder
	 */
	@InitBinder("subcategory")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.setValidator(new SubcategoryValidator(subcategoryService));
	}

	/**
	 * Creates and returns new empty {@code SubcategoryFilter} object
	 * @return new empty {@code SubcategoryFilter} object
	 */
	@ModelAttribute("filter")
	public SubcategoryFilter getFilter(){
		return new SubcategoryFilter();
	}

	/**
	 * Creates and returns new empty {@code Subcategory} object
	 * @return new empty {@code Subcategory} object
	 */
	@ModelAttribute("subcategory")
	public Subcategory getForm(){
		return new Subcategory();
	}


	/**
	 * This method gets all {@code Subcategory}'s in DataBase in Pageable perspective
	 * @param model model we use
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping
	public String show(Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") SubcategoryFilter filter){
		model.addAttribute("page", subcategoryService.findAll(pageable,filter));
		model.addAttribute("categories", categoryService.findAll());
		return "admin-subcategModer";
	}

	/**
	 * This method deletes specified {@code Subcategory} using Get request
	 * on {/admin/subcategModer/delete/[id]} link
	 * @param id id of {@code Subcategory} we want to delete
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") SubcategoryFilter filter){
		subcategoryService.delete(id);
		return "redirect:/admin/subcategModer"+getParams(pageable,filter);
	}

	/**
	 * This method updates specified {@code Subcategory} using Get request
	 * on {/admin/subcategModer/update/[id]} link
	 * @param id id of {@code Subcategory} we want to update
	 * @param model model we use
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") SubcategoryFilter filter){
		model.addAttribute("subcategory", subcategoryService.findOne(id));
		return show(model,pageable,filter);
	}

	/**
	 * This method saves new {@code Subcategory} to database
	 * using Post method
	 * @param subcategory {@code Subcategory} to save
	 * @param br {@code BindingResult} object to check for any validation errors
	 * @param model model we use
	 * @param status {@code SessionStatus} to manipulate current session
	 * @param pageable pagination settings
	 * @param filter {@SimpleFilter} filtering settings
	 * @return link for redirection
	 */
	@PostMapping
	public String save(@ModelAttribute("subcategory")@Valid Subcategory subcategory,
			BindingResult br,Model model, SessionStatus status,
			@PageableDefault Pageable pageable, @ModelAttribute("filter") SubcategoryFilter filter){
		if(br.hasErrors()) return show(model,pageable,filter);
		subcategoryService.save(subcategory);
		status.setComplete();
		return "redirect:/admin/subcategModer"+getParams(pageable,filter);
	}

	/**
	 * Gets and returns attributes specified by client for filtering purposes
	 * @param pageable Pageable settings
	 * @param filter used {@code SubcategoryFilter}
	 * @return String that will be added to link for filtering purposes
	 */
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
