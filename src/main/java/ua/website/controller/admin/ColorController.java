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
import ua.website.entity.Color;
import ua.website.service.ColorService;
import ua.website.validator.ColorValidator;

import static ua.website.util.ParamBuilder.*;


/**
 * Controller that will be called on {/admin/colorModer} link;
 * makes CRUD operations and manipulations with {@Color} Entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Color
 * @see ua.website.service.ColorService
 * @see ua.website.validator.ColorValidator
 * @see ua.website.dto.filter.SimpleFilter
 */
@Controller
@RequestMapping("/admin/colorModer")
@SessionAttributes("color")
public class ColorController {

	/** Injected {@code ColorService} used in this Controller*/
	@Autowired
	private ColorService colorService;

	/** Binds validator for {@Color} objects */
	@InitBinder("color")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new ColorValidator(colorService));
	}

	/**
	 * Creates and returns new empty {@code Color} object
	 * @return new empty {@code Color} object
	 */
	@ModelAttribute("color")
	public Color getForm(){
		return new Color();
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
	 * This method gets all {@code Color}'s in DataBase in Pageable perspective
	 * @param model model we use
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping
	public String show(Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("page", colorService.findAll(filter,pageable));
		return "admin-colorModer";
	}

	/**
	 * This method updates specified {@code Color} using Get request
	 * on {/admin/colorModer/update/[id]} link
	 * @param id id of {@code Color} we want to update
	 * @param model model we use
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("color", colorService.findOne(id));
		show(model,pageable,filter);
		return "admin-colorModer";
	}

	/**
	 * This method deletes specified {@code Color} using Get request
	 * on {/admin/colorModer/delete/[id]} link
	 * @param id id of {@code Color} we want to delete
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		colorService.delete(id);
		return "redirect:/admin/colorModer"+getParams(pageable,filter);
	}

	/**
	 * This method saves new {@code Color} to database
	 * using Post method
	 * @param color {@code Color} to save
	 * @param br {@code BindingResult} object to check for any validation errors
	 * @param model model we use
	 * @param status {@code SessionStatus} to manipulate current session
	 * @param pageable pagination settings
	 * @param filter {@SimpleFilter} filtering settings
	 * @return link for redirection
	 */
	@PostMapping
	public String save(@ModelAttribute("color")@Valid Color color,BindingResult br,
			Model model,SessionStatus status,
			@PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		if(br.hasErrors()) return show(model,pageable,filter);
		colorService.save(color);
		status.setComplete();
		return "redirect:/admin/colorModer"+getParams(pageable, filter);
	}
}