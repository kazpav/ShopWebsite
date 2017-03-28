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

@Controller
@RequestMapping("/admin/countryModer")
@SessionAttributes("country")
public class CountryController {
	
	
	@Autowired
	private CountryService countryService;
	
	
	@InitBinder("country")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new CountryValidator(countryService));
	}
	
	@ModelAttribute("country")
	public Country getForm(){
		return new Country();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@GetMapping
	public String show(Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("page", countryService.findAll(filter,pageable));
		return "admin-countryModer";
	}
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("country", countryService.findOne(id));
		show(model,pageable,filter);
		return "admin-countryModer";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable,@ModelAttribute("filter") SimpleFilter filter){
		countryService.delete(id);
		return "redirect:/admin/countryModer"+getParams(pageable,filter);
	}
	
	
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
