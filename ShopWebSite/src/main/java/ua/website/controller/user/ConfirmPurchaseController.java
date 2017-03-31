package ua.website.controller.user;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.website.dto.form.PurchaseContactForm;
import ua.website.entity.PurchaseContact;
import ua.website.entity.SaleStatus;
import ua.website.entity.UserCommodity;
import ua.website.service.PurchaseContactService;
import ua.website.service.UserCommodityService;
import ua.website.service.UserService;

@Controller
@RequestMapping("/confirmpurchase")
public class ConfirmPurchaseController {

	@Autowired
	private UserCommodityService userCommodityService;
	@Autowired
	private PurchaseContactService purchaseContactService;
	@Autowired
	private UserService userService;

	@GetMapping
	public String show(Model model,Principal principal){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		model.addAttribute("date", dateFormat.format(date));
		int id = userService.findByEmail(principal.getName()).getId();
		model.addAttribute("userCommodities",
				userCommodityService.findUserPurchases(id, SaleStatus.STATUS_INBASKET));
		return "user-confirmpurchase";
	}
	
	@ModelAttribute("form")
	public PurchaseContactForm getForm() {
		return new PurchaseContactForm();
	}

	@PostMapping
	public String savePurchaseContact(
			@ModelAttribute("form") PurchaseContactForm purchaseContactForm,
			Principal principal) {
		if (principal != null) {
			PurchaseContact pc = purchaseContactService
					.convertFormToEntity(purchaseContactForm);
			purchaseContactService.save(pc);
			List<UserCommodity> list = userCommodityService.findUserPurchases(
					userService.findByEmail(principal.getName()).getId(),
					SaleStatus.STATUS_INBASKET);
			userCommodityService.confirmPurchase(list, pc);

		}
		return "redirect:/";
	}
}
