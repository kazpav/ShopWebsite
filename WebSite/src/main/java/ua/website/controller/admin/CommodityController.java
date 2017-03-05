package ua.website.controller.admin;

import java.math.BigDecimal;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.website.dto.form.CommodityForm;
import ua.website.editor.ColorEditor;
import ua.website.editor.CountryEditor;
import ua.website.editor.FabricatorEditor;
import ua.website.editor.SubcategoryEditor;
import ua.website.entity.Category;
import ua.website.entity.Color;
import ua.website.entity.Commodity;
import ua.website.entity.Country;
import ua.website.entity.Fabricator;
import ua.website.entity.Subcategory;
import ua.website.service.ColorService;
import ua.website.service.CommodityService;
import ua.website.service.CountryService;
import ua.website.service.FabricatorService;
import ua.website.service.SubcategoryService;
import ua.website.validator.CommodityValidator;

@Controller
@RequestMapping("/admin/commodityModer")
@SessionAttributes("commodity")
public class CommodityController {

	@Autowired
	CommodityService commodityService;
	@Autowired
	SubcategoryService subcategoryService;
	@Autowired
	ColorService colorService;
	@Autowired
	CountryService countryService;
	@Autowired
	FabricatorService fabricatorService;

	
	@InitBinder("commodity")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
		binder.registerCustomEditor(Fabricator.class, new FabricatorEditor(fabricatorService));
		binder.registerCustomEditor(Subcategory.class, new SubcategoryEditor(subcategoryService));
		binder.setValidator(new CommodityValidator(commodityService));
	}
	
	
	@ModelAttribute("commodity")
	public CommodityForm getForm(){
		return new CommodityForm();
	}
	
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("commodities", commodityService.findAll());
		model.addAttribute("subcategories", subcategoryService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("fabricators", fabricatorService.findAll());
		return "admin-commodityModer";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		commodityService.delete(id);
		return "redirect:/admin/commodityModer";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("commodity", commodityService.findForm(id));
		return show(model);
	}

	@PostMapping
	public String save(@ModelAttribute("commodity")@Valid CommodityForm commodity,
			BindingResult br,Model model, SessionStatus status) {
		if(br.hasErrors()) return show(model);
		
		
		commodity.setCategory(subcategoryService.findOne(commodity.getSubcategory().getId()).getCategory());
		commodityService.save(commodity);
		status.setComplete();
		return "redirect:/admin/commodityModer";
	}
}
