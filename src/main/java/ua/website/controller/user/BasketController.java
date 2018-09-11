package ua.website.controller.user;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.website.dto.form.UserCommodityForm;
import ua.website.editor.CommodityEditor;
import ua.website.editor.UserEditor;
import ua.website.entity.Commodity;
import ua.website.entity.SaleStatus;
import ua.website.entity.User;
import ua.website.entity.UserCommodity;
import ua.website.service.CategoryService;
import ua.website.service.CommodityService;
import ua.website.service.UserCommodityService;
import ua.website.service.UserService;
import ua.website.validator.BasketValidator;

/**
 * Controller that will be called on {/basket} link;
 * shows to {@code User} all {@code Commodity}'s he chose
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.User
 * @see ua.website.entity.Commodity
 * @see ua.website.service.UserCommodityService
 * @see ua.website.service.CategoryService
 * @see ua.website.service.UserService
 * @see ua.website.service.CommodityService
 * @see ua.website.validator.BasketValidator
 * @see ua.website.dto.form.UserCommodityForm
 * @see ua.website.editor.UserEditor
 * @see ua.website.editor.CommodityEditor
 */
@Controller
@RequestMapping("/basket")
@SessionAttributes("form")
public class BasketController {

	/** Injected {@code UserCommodityService} used in this Controller*/
	@Autowired
	private UserCommodityService userCommodityService;

	/** Injected {@code UserService} used in this Controller*/
	@Autowired
	private UserService userService;

	/** Injected {@code CategoryService} used in this Controller*/
	@Autowired
	private CategoryService categoryService;

	/** Injected {@code CommodityService} used in this Controller*/
	@Autowired
	private CommodityService commodityService;

	/**
	 * Binds editors and validators used in basket
	 * @param binder used binder
	 */
	@InitBinder("form")
	protected void binder(WebDataBinder binder){
		binder.registerCustomEditor(User.class, new UserEditor(userService));
		binder.registerCustomEditor(Commodity.class, new CommodityEditor(commodityService));
		binder.setValidator(new BasketValidator(userCommodityService));
	}

	/**
	 * Creates and returns new empty {@code UserCommodityForm}
	 * @return new empty {@code UserCommodityForm} object
	 */
	@ModelAttribute("form")
	public UserCommodityForm getForm() {
		return new UserCommodityForm();
	}

	/**
	 * Shows all {@code Commodities} chose by {@code User}
	 * @param model model we use
	 * @param principal {@code Principal} object to identify {@code User}
	 * @return redirect link
	 */
	@GetMapping
	public String show(Model model, Principal principal) {
		if (principal != null) {
			int id = userService.findByEmail(principal.getName()).getId();
			model.addAttribute("userCommodities",
					userCommodityService.findUserPurchases(id, SaleStatus.STATUS_INBASKET));
			model.addAttribute("status_inbasket", SaleStatus.STATUS_INBASKET);
			model.addAttribute("summaryCost", userCommodityService.findSummCostForUser(id, SaleStatus.STATUS_INBASKET));
		}
		return "user-basket";
	}

	/**
	 * This method deletes item from basket
	 * means it deletes {@code UserCommodity} object
	 * @param id {@code UserCommodity} object id
	 * @param principal {@code Principal} object to identify {@code User}
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, Principal principal) {
		if (principal != null) {
			if (userService.findByEmail(principal.getName()).getId() == userCommodityService
					.findOne(id).getUser().getId()) {
				UserCommodity uc = userCommodityService.findOne(id);
				Commodity comm = uc.getCommodity();
				comm.setQuantity(comm.getQuantity()+uc.getNumber());
				commodityService.save(comm);
				userCommodityService.delete(id);
				return "redirect:/basket";
			} else {
				return "redirect:/";
			}
		}
		return "redirect:/";
	}

	/**
	 * This method changes quantity of items for this {@code User}
	 * also checks if such quantity is availiable
	 * @param userCommodity {@code UserCommodity} object to change
	 * @param br {@code BindingResult} object to check validation errors
	 * @param model model we use
	 * @param principal {@code Principal} object we use to identify User
	 * @param sessionStatus Session Status
	 * @return link to redirect
	 */
	@PostMapping
	public String changeQuantity(@ModelAttribute("form")@Valid UserCommodityForm userCommodity,
			BindingResult br, Model model,Principal principal, SessionStatus sessionStatus){
		if(principal!=null){
			if(br.hasErrors()) return show(model, principal);
			UserCommodity uc = userCommodityService.findUnique(userCommodity.getUser().getId(), userCommodity.getCommodity().getId(), userCommodity.getStatus());
			Commodity comm = userCommodity.getCommodity();
			comm.setQuantity(comm.getQuantity()+uc.getNumber()-Integer.parseInt(userCommodity.getNumber()));
			commodityService.save(comm);
			uc.setNumber(Integer.parseInt(userCommodity.getNumber()));
			userCommodityService.save(uc);
		}
		sessionStatus.setComplete();
		return "redirect:/basket";
	}
}
