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

/**
 * Controller that will be called on {/admin/currentPurchases} link;
 * Shows all confirmed purchases that need to be handled
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.UserCommodity
 * @see ua.website.entity.PurchaseContact
 * @see ua.website.entity.Commodity
 * @see ua.website.service.UserCommodityService
 * @see ua.website.service.PurchaseContactService
 * @see ua.website.service.CommodityService
 * @see ua.website.validator.CountryValidator
 * @see ua.website.dto.filter.SimpleFilter
 */
@Controller
@RequestMapping("/admin/currentPurchases")
public class CurrentPurchasesController {

	/** Injected {@code PurchaseContactService} used in this Controller*/
	@Autowired
	private PurchaseContactService purchaseContactService;

	/** Injected {@code UserCommodityService} used in this Controller*/
	@Autowired
	private UserCommodityService userCommodityService;

	/** Injected {@code CommodityService} used in this Controller*/
	@Autowired
	private CommodityService commodityService;

	/**
	 * This method gets all {@code UserCommodities}'s
	 * with {@code SaleStatus.STATUS_CONFIRMED}in DataBase in
	 * @param model model we use
	 * @return link for redirection
	 */
	@GetMapping
	public String show(Model model){
		model.addAttribute("userCommodities", userCommodityService.findPurchases(SaleStatus.STATUS_CONFIRMED));
		return "admin-currentPurchases";
	}

	/**
	 * This method deletes specified {@code UserCommodity} using Get request
	 * on {/admin/currentPurchases/delete/[id]} link
	 * @param id id of {@code UserCommodity} we want to delete
	 * @return link for redirection
	 */
	@GetMapping("/delete/{id}")
	public String deletePurchase(@PathVariable int id){
		UserCommodity uc = userCommodityService.findOne(id);
		Commodity comm = uc.getCommodity();
		comm.setQuantity(comm.getQuantity()+uc.getNumber());
		commodityService.save(comm);
		userCommodityService.delete(id);
		return "redirect:/admin/currentPurchases";
	}

	/**
	 * This method confirms purchases and sets
	 * status {@code SaleStatus.STATUS_SOLD}
	 * to {@code UserCommodity}
	 * @param id {@code UserCommodity} id to confirm
	 * @return redirect link
	 */
	@GetMapping("/confirmsale/{id}")
	public String confirmSale(@PathVariable int id){
		UserCommodity uc = userCommodityService.findOne(id);
		uc.setStatus(SaleStatus.STATUS_SOLD);
		userCommodityService.save(uc);
		return "redirect:/admin/currentPurchases";
	}
	
}
