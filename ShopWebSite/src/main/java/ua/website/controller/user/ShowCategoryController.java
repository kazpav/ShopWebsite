package ua.website.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.website.service.CategoryService;
import ua.website.service.ColorService;
import ua.website.service.CommodityService;

/**
 * Controller that will be called on {/category} link;
 * describes page that shows all {@code Commodity}'s
 * related to chosen {@code Category}
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 * @see ua.website.entity.Category
 * @see ua.website.service.CategoryService
 * @see ua.website.service.CommodityService
 */
@Controller
@RequestMapping("/category/{id}")
public class ShowCategoryController {

	/** Injected {@code CategoryService} used in this Controller*/
	@Autowired
	private CategoryService categoryService;

	/** Injected {@code CommodityService} used in this Controller*/
	@Autowired
	private CommodityService commodityService;

	/** Injected {@code ColorService} used in this Controller*/
	@Autowired
	private ColorService colorService;

	/**
	 * This method gets all Entities we need to be
	 * displayed on this page
	 * @param id {@code Category}'s id we need
	 * @param model model we use
	 * @return redirect link
	 */
	@GetMapping
	public String category(@PathVariable int id, Model model){
		model.addAttribute("category", categoryService.findOne(id));
		model.addAttribute("commodities", commodityService.findByCategoryId(id));
		model.addAttribute("categories", categoryService.findAll());
		return "user-category";
	}
}
