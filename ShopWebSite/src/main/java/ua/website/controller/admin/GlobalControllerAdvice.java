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

/**
 * This is Controller Advice that works all over the application
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.service.UserService
 * @see ua.website.service.UserCommodityService
 * @see ua.website.dto.filter.CommodityFilter
 */
@ControllerAdvice(basePackages = "ua.website.controller")
public class GlobalControllerAdvice {

	/** Injected {@code UserService} used in this Controller*/
	@Autowired
	private UserService userService;

	/** Injected {@code UserCommodityService} used in this Controller*/
	@Autowired
	private UserCommodityService userCommodityService;

	/**
	 * Checks User to show all necessary information in header
	 * @param model model we use
	 * @param principal {@code Principal} object to check user
	 */
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

	/**
	 * Blank for method that will save {@code User}'s by their Cookie value
	 * Not finished
	 * @param id {@code User} id
	 * @param response response
	 */
	@ModelAttribute
	public void userCookie(@CookieValue(defaultValue="0",name="userId")int id, HttpServletResponse response){
		if(id==0){
			id = userService.createNewUser();
			response.addCookie(new Cookie("userId", String.valueOf(id)));
		}
	}

	/**
	 * Creates new {@code CommodityFilter} that will be used in
	 * search form
	 * @return new {@code CommodityFilter} object
	 */
	@ModelAttribute("searchFilter")
	public CommodityFilter getFilter() {
		return new CommodityFilter();
	}

}
