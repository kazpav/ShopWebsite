package ua.website.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.website.service.CategoryService;

/**
 * Controller that will be called on {/infopage} link;
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Category
 * @see ua.website.service.CategoryService
 */
@Controller
@RequestMapping("/infopage")
public class InfopageController {

	/** Injected {@code Category} used in this Controller*/
	@Autowired
	private CategoryService categoryService;

	/**
	 * Finds all {@code Category}'s in DataBase
	 * @param model model we use
	 * @return this page link
	 */
	@GetMapping
	public String show(Model model){
		model.addAttribute("categories", categoryService.findAll());
		return "user-infopage";
	}
}
