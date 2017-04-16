package ua.website.controller.admin;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

import ua.website.dto.filter.CommodityFilter;
import ua.website.entity.SaleStatus;
import ua.website.entity.User;
import ua.website.service.UserCommodityService;
import ua.website.service.UserService;

@ControllerAdvice(basePackages = "ua.website.controller")
public class GlobalControllerAdvice {

	@Autowired
	private UserService userService;
	@Autowired
	private UserCommodityService userCommodityService;

	@ModelAttribute
	public void usercheck(Model model, Principal principal) {
		if (principal != null) {
			User user = userService.findByEmail(principal.getName());
			model.addAttribute("user", user);
			model.addAttribute("purchaseQuantity", userCommodityService
					.findQuantityOfUserPurchasesInBaset(user.getId(),
							SaleStatus.STATUS_INBASKET));
			if (principal.getName().equals("admin")) {
				model.addAttribute(
						"quantityOfConfirmedPurchases",
						userCommodityService
								.findQuantityOfConfirmedPurchases(SaleStatus.STATUS_CONFIRMED));
			}
		}
	}
	
	@ModelAttribute
	public void userCookie(@CookieValue(defaultValue="0",name="userId")int id, HttpServletResponse response){
		if(id==0){
			id = userService.createNewUser();
			response.addCookie(new Cookie("userId", String.valueOf(id)));
		}
	}

	@ModelAttribute("searchFilter")
	public CommodityFilter getFilter() {
		return new CommodityFilter();
	}

}
