package ua.website.controller.user;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.website.entity.User;
import ua.website.service.CategoryService;
import ua.website.service.UserCommodityService;
import ua.website.service.UserService;

@Controller
@RequestMapping("/basket")
public class BasketController {
	
	
	@Autowired
	private UserCommodityService userCommodityService;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String show(Model model, Principal principal){
		if(principal!=null){
		int id = userService.findByEmail(principal.getName()).getId();
		model.addAttribute("userCommodities", userCommodityService.findComByUser(id));
		}
		return "user-basket";
	}
}
