package ua.website.controller.user;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
import ua.website.validator.PurchaseContactValidator;


/**
 * Controller that will be called on {/confirmpurchase} link;
 * works with {@code @PurchaseContact} Entities
 * when user gives his contact info
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.User
 * @see ua.website.entity.PurchaseContact
 * @see ua.website.entity.UserCommodity
 * @see ua.website.service.UserCommodityService
 * @see ua.website.service.PurchaseContactService
 * @see ua.website.service.UserService
 * @see ua.website.validator.PurchaseContactValidator
 * @see ua.website.dto.form.PurchaseContactForm
 */
@Controller
@RequestMapping("/confirmpurchase")
public class ConfirmPurchaseController {

	/** Injected {@code UserCommodityService} used in this Controller*/
	@Autowired
	private UserCommodityService userCommodityService;

	/** Injected {@code PurchaseContactService} used in this Controller*/
	@Autowired
	private PurchaseContactService purchaseContactService;

	/** Injected {@code UserService} used in this Controller*/
	@Autowired
	private UserService userService;

	/**
	 * This method gets {@code User} information, date information
	 * and {@code UserCommodity} information that will be used
	 * to create {@code PurchaseContact} object
	 * @param model model we use
	 * @param principal {@code Principal} object to get current {@code User}
	 * @return
	 */
	@GetMapping
	public String show(Model model,Principal principal){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		model.addAttribute("date", dateFormat.format(date));
		int id = userService.findByEmail(principal.getName()).getId();
		model.addAttribute("userCommodities",
				userCommodityService.findUserPurchases(id, SaleStatus.STATUS_INBASKET));
		return "user-confirmpurchase";
	}

	/** Binds validator for {@PurchaseContact} objects */
	@InitBinder("form")
	protected void binder(WebDataBinder binder){
		binder.setValidator(new PurchaseContactValidator(purchaseContactService));
	}

	/**
	 * Creates and returns new empty {@code PurchaseContactForm} object
	 * @return new empty {@code PurchaseContactForm} object
	 */
	@ModelAttribute("form")
	public PurchaseContactForm getForm() {
		return new PurchaseContactForm();
	}

	/**
	 * This method saves new {@code PurchaseContact} to database
	 * using Post method
	 * @param purchaseContactForm {@code PurchaseContact} to save
	 * @param br {@code BindingResult} object to check for any validation errors
	 * @param model model we use
	 * @param principal {@code Principal} object to identify {@code User}
	 * @return link for redirection
	 */
	@PostMapping
	public String savePurchaseContact(
			@ModelAttribute("form")@Valid PurchaseContactForm purchaseContactForm,
			BindingResult br, Model model,
			Principal principal/*, SessionStatus sessionStatus*/) {
		if (principal != null) {
			if(br.hasErrors()) return show(model, principal);
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
