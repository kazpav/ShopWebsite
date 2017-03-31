package ua.website.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.website.entity.Commodity;
import ua.website.entity.SaleStatus;
import ua.website.entity.UserCommodity;
import ua.website.service.CommodityService;
import ua.website.service.PurchaseContactService;
import ua.website.service.UserCommodityService;

@Controller
@RequestMapping("/admin/currentPurchases")
public class CurrentPurchasesController {

	
	@Autowired
	private PurchaseContactService purchaseContactService;
	@Autowired
	private UserCommodityService userCommodityService;
	@Autowired
	private CommodityService commodityService; 
	
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("userCommodities", userCommodityService.findPurchases(SaleStatus.STATUS_CONFIRMED));
		return "admin-currentPurchases";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePurchase(@PathVariable int id){
		UserCommodity uc = userCommodityService.findOne(id);
		Commodity comm = uc.getCommodity();
		comm.setQuantity(comm.getQuantity()+uc.getNumber());
		commodityService.save(comm);
		userCommodityService.delete(id);
		return "redirect:/admin/currentPurchases";
	}
	@GetMapping("/confirmsale/{id}")
	public String confirmSale(@PathVariable int id){
		UserCommodity uc = userCommodityService.findOne(id);
		uc.setStatus(SaleStatus.STATUS_SOLD);
		userCommodityService.save(uc);
		return "redirect:/admin/currentPurchases";
	}
	
}
