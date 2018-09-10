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
import ua.website.entity.Country;
import ua.website.service.CountryService;
import ua.website.validator.CountryValidator;

import static ua.website.util.ParamBuilder.*;

/**
 * Controller that will be called on {/admin/countryModer} link;
 * makes CRUD operations and manipulations with {@Country} Entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Country
 * @see ua.website.service.CountryService
 * @see ua.website.validator.CountryValidator
 * @see ua.website.dto.filter.SimpleFilter
 */
@Controller
@RequestMapping("/admin/countryModer")
@SessionAttributes("country")
public class CountryController {

	/** Injected {@code CountryService} used in this Controller*/
	@Autowired
	private CountryService countryService;

	/** Binds validator for {@Country} objects */
	@InitBinder("country")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new CountryValidator(countryService));
	}

	/**
	 * Creates and returns new empty {@code Country} object
	 * @return new empty {@code Country} object
	 */
	@ModelAttribute("country")
	public Country getForm(){
		return new Country();
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
	 * This method gets all {@code Country}'s in DataBase in Pageable perspective
	 * @param model model we use
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping
	public String show(Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("page", countryService.findAll(filter,pageable));
		return "admin-countryModer";
	}

	/**
	 * This method updates specified {@code Country} using Get request
	 * on {/admin/countryModer/update/[id]} link
	 * @param id id of {@code Country} we want to update
	 * @param model model we use
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("country", countryService.findOne(id));
		show(model,pageable,filter);
		return "admin-countryModer";
	}

	/**
	 * This method deletes specified {@code Country} using Get request
	 * on {/admin/countryModer/delete/[id]} link
	 * @param id id of {@code Country} we want to delete
	 * @param pageable Pageable settings we use
	 * @param filter Filtering settings we use
	 * @return link for redirection
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter){
		countryService.delete(id);
		return "redirect:/admin/countryModer"+getParams(pageable,filter);
	}

	/**
	 * This method saves new {@code Country} to database
	 * using Post method
	 * @param country {@code Country} to save
	 * @param br {@code BindingResult} object to check for any validation errors
	 * @param model model we use
	 * @param status {@code SessionStatus} to manipulate current session
	 * @param pageable pagination settings
	 * @param filter {@SimpleFilter} filtering settings
	 * @return link for redirection
	 */
	@PostMapping
	public String save(@ModelAttribute("country")@Valid Country country,
					   BindingResult br, Model model, SessionStatus status,
					   @PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter){
		if(br.hasErrors()) return show(model,pageable,filter);
		countryService.save(country);
		status.setComplete();
		return "redirect:/admin/countryModer"+getParams(pageable,filter);
	}

}

