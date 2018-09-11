package ua.website.controller.user;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.website.service.CategoryService;
import ua.website.service.CommodityService;
import ua.website.service.CountryService;
import ua.website.service.UserService;


/**
 * Controller that will be called on start page;
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.User
 * @see ua.website.entity.Commodity
 * @see ua.website.entity.Category
 * @see ua.website.entity.Country
 * @see ua.website.service.CategoryService
 * @see ua.website.service.CommodityService
 * @see ua.website.service.UserService
 * @see ua.website.service.CountryService
 */
@Controller
public class IndexController {

	/** Injected {@code CategoryService} used in this Controller*/
	@Autowired
	private CategoryService categoryService;

	/** Injected {@code CommodityService} used in this Controller*/
	@Autowired
	private CommodityService commodityService;

	/** Injected {@code UserService} used in this Controller*/
	@Autowired
	private UserService userService;

	/** Injected {@code CountryService} used in this Controller*/
	@Autowired
	private CountryService countryService;

	/** Logger used in this class*/
	private static final Logger logger = LogManager.getLogger(IndexController.class.getName());

	/**
	 * Gets all {@code Category}'s to display them on index page
	 * and random {@code Commodity}'s to display them on slider
	 * @param model model we use
	 * @return link to redirect
	 */
	@RequestMapping("/")
	public String index(Model model){
		logger.info("Index loaded");
		logger.trace("trace");
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("randomCommodities",commodityService.getRandomCommodities(5));
		return "user-index";
	}

}
