package ua.website.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.website.dto.filter.CommodityFilter;
import ua.website.service.CategoryService;
import ua.website.service.ColorService;
import ua.website.service.CommodityService;
import ua.website.service.CountryService;
import ua.website.service.FabricatorService;
import ua.website.service.SubcategoryService;
import ua.website.util.ParamBuilder;

/**
 * Controller that will be called on {/search} link;
 * allows to search for {@code Commodities} with specified properties
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 * @see ua.website.entity.Subcategory
 * @see ua.website.entity.Color
 * @see ua.website.entity.Country
 * @see ua.website.entity.Category
 * @see ua.website.entity.Fabricator
 * @see ua.website.service.CommodityService
 * @see ua.website.service.SubcategoryService
 * @see ua.website.service.ColorService
 * @see ua.website.service.CountryService
 * @see ua.website.service.FabricatorService
 * @see ua.website.service.CategoryService
 * @see ua.website.dto.filter.CommodityFilter
 */
@Controller
@RequestMapping("/search")
public class SearchController {

	/** Injected {@code CommodityService} used in this Controller*/
	@Autowired
	CommodityService commodityService;

	/** Injected {@code SubcategoryService} used in this Controller*/
	@Autowired
	SubcategoryService subcategoryService;

	/** Injected {@code ColorService} used in this Controller*/
	@Autowired
	ColorService colorService;

	/** Injected {@code CountryService} used in this Controller*/
	@Autowired
	CountryService countryService;

	/** Injected {@code FabricatorService} used in this Controller*/
	@Autowired
	FabricatorService fabricatorService;

	/** Injected {@code CategoryService} used in this Controller*/
	@Autowired
	CategoryService categoryService;

	/**
	 * This method creates and returns new {@code CommodityFilter}
	 * @return new {@code CommodityFilter}
	 */
	@ModelAttribute("searchFilter")
	public CommodityFilter getFilter(){
		return new CommodityFilter();
	}

	/**
	 * This method gets all Entities we need during search
	 * @param model mode we use
	 * @param pageable Pageable settings
	 * @param filter used filter
	 * @return
	 */
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("searchFilter") CommodityFilter filter){
		model.addAttribute("page", commodityService.findAll(pageable,filter));
		model.addAttribute("subcategories", subcategoryService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("fabricators", fabricatorService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return "user-search";
	}

	/**
	 * This method gets all filtration settings
	 * to add them to link
	 * @param pageable Pageable settings
	 * @param filter filter settings
	 * @return
	 */
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
