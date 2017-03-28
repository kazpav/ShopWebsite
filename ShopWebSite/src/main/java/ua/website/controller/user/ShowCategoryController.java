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


@Controller
@RequestMapping("/category/{id}")
public class ShowCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private ColorService colorService;
	
	@GetMapping
	public String category(@PathVariable int id, Model model){
		model.addAttribute("category", categoryService.findOne(id));
		model.addAttribute("commodities", commodityService.findByCategoryId(id));
		model.addAttribute("categories", categoryService.findAll());
		return "user-category";
	}
}
