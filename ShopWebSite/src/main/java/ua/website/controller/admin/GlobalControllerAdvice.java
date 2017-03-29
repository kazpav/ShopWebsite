package ua.website.controller.admin;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import ua.website.dto.filter.CommodityFilter;
import ua.website.entity.User;
import ua.website.service.UserService;

@ControllerAdvice(basePackages = "ua.website.controller")
public class GlobalControllerAdvice {

	@Autowired
	private UserService userService;

	@ModelAttribute
	public void usercheck(Model model, Principal principal) {
		if (principal != null) {
			model.addAttribute("user",
					userService.findByEmail(principal.getName()));
		}
	}
	
	@ModelAttribute("searchFilter")
	public CommodityFilter getFilter(){
		return new CommodityFilter();
	}

}
