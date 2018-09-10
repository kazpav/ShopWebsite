package ua.website.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.website.entity.SaleStatus;
import ua.website.service.UserCommodityService;

/**
 * Controller that will be called on {/admin/salesHistory} link;
 * All accomplished purchases are shown here
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.UserCommodity
 * @see ua.website.service.UserCommodityService
 */
@Controller
@RequestMapping("/admin/salesHistory")
public class SalesHistoryController {

	/** Injected {@code UserCommodityService} used in this Controller*/
	@Autowired
	private UserCommodityService userCommodityService;

	/**
	 * This method shows all purchases with status {@code SaleStatus.STATUS_SOLD}
	 * @param model model we use
	 * @return link to redirect
	 */
	@GetMapping
	public String show(Model model){
		model.addAttribute("userCommodities", userCommodityService.findPurchases(SaleStatus.STATUS_SOLD));
		return "admin-salesHistory";

	}
}
