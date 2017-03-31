package ua.website.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.website.entity.SaleStatus;
import ua.website.service.UserCommodityService;

@Controller
@RequestMapping("/admin/salesHistory")
public class SalesHistoryController {

	@Autowired
	private UserCommodityService userCommodityService;

	
	@GetMapping
	public String show(Model model){
		model.addAttribute("userCommodities", userCommodityService.findPurchases(SaleStatus.STATUS_SOLD));
		return "admin-salesHistory";

	}
}
