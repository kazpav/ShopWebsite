package ua.website.controller.user;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.website.entity.Commodity;
import ua.website.entity.User;
import ua.website.entity.UserCommodity;
import ua.website.service.CategoryService;
import ua.website.service.CommodityService;
import ua.website.service.UserCommodityService;
import ua.website.service.UserService;

@Controller
@RequestMapping("/commodity/{id}")
@SessionAttributes("form")
public class ShowCommodityController {

	@Autowired
	private CommodityService commodityService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserCommodityService userCommodityService;
	@Autowired
	private CategoryService categoryService;

	@ModelAttribute("form")
	public UserCommodity getForm() {
		return new UserCommodity();
	}

	@GetMapping
	public String show(@PathVariable int id, Model model) {
		model.addAttribute("commodity", commodityService.findOne(id));
		model.addAttribute("categories", categoryService.findAll());

		return "user-commodity";
	}

	@PostMapping
	public String addToBasket(
			@ModelAttribute("form") UserCommodity userCommodity,
			Principal principal, @PathVariable int id, SessionStatus status) {
		if (principal != null) {
			Commodity commodity = commodityService.findOne(id);
			User user = userService.findByEmail(principal.getName());
			userCommodity.setUser(user);
			userCommodity.setCommodity(commodity);
			userCommodityService.save(userCommodity);
			status.setComplete();
		}

		return "redirect:/commodity/{id}";
	}
}
