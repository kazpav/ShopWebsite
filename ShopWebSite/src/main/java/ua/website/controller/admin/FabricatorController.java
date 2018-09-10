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
import ua.website.entity.Fabricator;
import ua.website.service.FabricatorService;
import ua.website.validator.FabricatorValidator;

import static ua.website.util.ParamBuilder.*;


/**
 * Controller that will be called on {/admin/fabricatorModer} link;
 * makes CRUD operations and manipulations with {@Fabricator} Entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Fabricator
 * @see ua.website.service.FabricatorService
 * @see ua.website.validator.FabricatorValidator
 * @see ua.website.dto.filter.SimpleFilter
 */
@Controller
@RequestMapping("/admin/fabricatorModer")
@SessionAttributes("fabricator")
public class FabricatorController {

	/** Injected {@code FabricatorService} used in this Controller*/
	@Autowired
	FabricatorService fabricatorService;

	/** Binds validator for {@Fabricator} objects */
	@InitBinder("fabricator")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new FabricatorValidator(fabricatorService));
	}

	/**
	 * Creates and returns new empty {@code Fabricator} object
	 * @return new empty {@code Fabricator} object
	 */
	@ModelAttribute("fabricator")
	public Fabricator getForm() {
		return new Fabricator();
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
	 * This method gets all {@code Fabricator}'s in DataBase in Pageable perspective
	 * @param model model we use
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("page", fabricatorService.findAll(filter,pageable));
		return "admin-fabricatorModer";
	}

	/**
	 * This method updates specified {@code Fabricator} using Get request
	 * on {/admin/fabricatorModer/update/[id]} link
	 * @param id id of {@code Fabricator} we want to update
	 * @param model model we use
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("fabricator", fabricatorService.findOne(id));
		show(model,pageable,filter);
		return "admin-fabricatorModer";
	}

	/**
	 * This method deletes specified {@code Fabricator} using Get request
	 * on {/admin/fabricatorModer/delete/[id]} link
	 * @param id id of {@code Fabricator} we want to delete
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		fabricatorService.delete(id);
		return "redirect:/admin/fabricatorModer"+getParams(pageable,filter);
	}

	/**
	 * This method saves new {@code Fabricator} to database
	 * using Post method
	 * @param fabricator {@code Fabricator} to save
	 * @param br {@code BindingResult} object to check for any validation errors
	 * @param model model we use
	 * @param status {@code SessionStatus} to manipulate current session
	 * @param pageable pagination settings
	 * @param filter {@SimpleFilter} filtering settings
	 * @return link for redirection
	 */
	@PostMapping
	public String save(@ModelAttribute("fabricator")@Valid Fabricator fabricator,
			BindingResult br,Model model, SessionStatus status,
			@PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		if(br.hasErrors()) return show(model,pageable,filter);
		fabricatorService.save(fabricator);
		status.setComplete();
		return "redirect:/admin/fabricatorModer"+getParams(pageable, filter);
	}

}
