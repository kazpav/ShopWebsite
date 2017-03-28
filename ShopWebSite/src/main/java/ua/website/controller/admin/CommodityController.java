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

import ua.website.dto.filter.CommodityFilter;
import ua.website.dto.form.CommodityForm;
import ua.website.editor.CategoryEditor;
import ua.website.editor.ColorEditor;
import ua.website.editor.CountryEditor;
import ua.website.editor.FabricatorEditor;
import ua.website.editor.SubcategoryEditor;
import ua.website.entity.Category;
import ua.website.entity.Color;
import ua.website.entity.Country;
import ua.website.entity.Fabricator;
import ua.website.entity.Subcategory;
import ua.website.service.CategoryService;
import ua.website.service.ColorService;
import ua.website.service.CommodityService;
import ua.website.service.CountryService;
import ua.website.service.FabricatorService;
import ua.website.service.SubcategoryService;
import ua.website.util.ParamBuilder;
import ua.website.validator.CommodityValidator;
import static ua.website.util.ParamBuilder.*;

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
	@Autowired
	CategoryService categoryService;

	
	@InitBinder("commodity")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
		binder.registerCustomEditor(Fabricator.class, new FabricatorEditor(fabricatorService));
		binder.registerCustomEditor(Subcategory.class, new SubcategoryEditor(subcategoryService));
		//added for test
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.setValidator(new CommodityValidator(commodityService));
	}
	
	@ModelAttribute("filter")
	public CommodityFilter getFilter(){
		return new CommodityFilter();
	}
	
	
	@ModelAttribute("commodity")
	public CommodityForm getForm(){
		return new CommodityForm();
	}
	
	
	@GetMapping
	public String show(Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") CommodityFilter filter) {
		model.addAttribute("page", commodityService.findAll(pageable, filter));
		model.addAttribute("subcategories", subcategoryService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("fabricators", fabricatorService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return "admin-commodityModer";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") CommodityFilter filter) {
		commodityService.delete(id);
		return "redirect:/admin/commodityModer"+getParams(pageable, filter);
	}
	
	

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") CommodityFilter filter){
		model.addAttribute("commodity", commodityService.findForm(id));
		return show(model,pageable,filter);
	}

	@PostMapping
	public String save(@ModelAttribute("commodity")@Valid CommodityForm commodity,
			BindingResult br,Model model, SessionStatus status,
			@PageableDefault Pageable pageable, @ModelAttribute("filter") CommodityFilter filter) {
		if(br.hasErrors()) return show(model,pageable,filter);
		
		
		commodity.setCategory(subcategoryService.findOne(commodity.getSubcategory().getId()).getCategory());
		commodityService.saveForm(commodity);
		status.setComplete();
		return "redirect:/admin/commodityModer"+getParams(pageable,filter);
	}
	
	
	private String getParams(Pageable pageable, CommodityFilter filter) {
		String page =ParamBuilder.getParams(pageable);
		StringBuilder builder = new StringBuilder(page);
		if(!filter.getNameSearch().isEmpty()){
			builder.append("&nameSearch");
			builder.append(filter.getNameSearch());
		}
		if(!filter.getMax().isEmpty()){
			builder.append("&max");
			builder.append(filter.getMax());
		}
		if(!filter.getMin().isEmpty()){
			builder.append("&min=");
			builder.append(filter.getMin());
		}
		if(!filter.getCountryId().isEmpty()){
			for (Integer id : filter.getCountryId()) {
				builder.append("&countryId=");
				builder.append(id);
			}
		}
		if(!filter.getColorId().isEmpty()){
			for (Integer id : filter.getColorId()) {
				builder.append("&colorId=");
				builder.append(id);
			}
		}
		if(!filter.getSubcategoryId().isEmpty()){
			for (Integer id : filter.getSubcategoryId()) {
				builder.append("&subcategoryId=");
				builder.append(id);
			}
		}
		if(!filter.getCategoryId().isEmpty()){
			for (Integer id : filter.getCategoryId()) {
				builder.append("&categoryId=");
				builder.append(id);
			}
		}

		if(!filter.getFabricatorId().isEmpty()){
			for (Integer id : filter.getFabricatorId()) {
				builder.append("&fabricatorId=");
				builder.append(id);
			}
		}
		return builder.toString();
	}
}
