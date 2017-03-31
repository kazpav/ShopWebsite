package ua.website.controller.user;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.website.dto.form.UserCommodityForm;
import ua.website.editor.CommodityEditor;
import ua.website.editor.UserEditor;
import ua.website.entity.Commodity;
import ua.website.entity.Role;
import ua.website.entity.SaleStatus;
import ua.website.entity.User;
import ua.website.entity.UserCommodity;
import ua.website.service.CategoryService;
import ua.website.service.CommodityService;
import ua.website.service.UserCommodityService;
import ua.website.service.UserService;
import ua.website.validator.BasketValidator;
import ua.website.validator.ShowCommodityValidator;

@Controller
@RequestMapping("/basket")
public class BasketController {

	@Autowired
	private UserCommodityService userCommodityService;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CommodityService commodityService;

	@InitBinder("form")
	protected void binder(WebDataBinder binder){
		binder.registerCustomEditor(User.class, new UserEditor(userService));
		binder.registerCustomEditor(Commodity.class, new CommodityEditor(commodityService));
		binder.setValidator(new BasketValidator(userCommodityService));
	}
	
	@ModelAttribute("form")
	public UserCommodityForm getForm() {
		return new UserCommodityForm();
	}
	
	@GetMapping
	public String show(Model model, Principal principal) {
		if (principal != null) {
			int id = userService.findByEmail(principal.getName()).getId();
			model.addAttribute("userCommodities",
					userCommodityService.findUserPurchases(id, SaleStatus.STATUS_INBASKET));
			model.addAttribute("status_inbasket", SaleStatus.STATUS_INBASKET);

		}
		return "user-basket";
	}

	
	
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
//	@GetMapping("/submitshopping/{id}")
//	public String submitShopping(@PathVariable int id, Principal principal){
//		if(principal!=null){
//			if(userService.findByEmail(principal.getName()).getId() == userCommodityService.findOne(id).getUser().getId()){
//				List<UserCommodity> list = userCommodityService.findUserPurchases(id, SaleStatus.STATUS_INBASKET);
//				userCommodityService.confirmPurchase(list);
//			}else{
//				return "redirect:/";
//			}
//		}
//		return "redirect:/";
//	}
	
	@PostMapping
	public String changeQuantity(@ModelAttribute("form")@Valid UserCommodityForm userCommodity,
			BindingResult br, Model model,Principal principal){
		if(principal!=null){
			if(br.hasErrors()) return show(model, principal);
			UserCommodity uc = userCommodityService.findUnique(userCommodity.getUser().getId(), userCommodity.getCommodity().getId(), userCommodity.getStatus());
			Commodity comm = userCommodity.getCommodity();
			comm.setQuantity(comm.getQuantity()+uc.getNumber()-Integer.parseInt(userCommodity.getNumber()));
			commodityService.save(comm);
			uc.setNumber(Integer.parseInt(userCommodity.getNumber()));
			userCommodityService.save(uc);
		}
		return "redirect:/basket";

	}
}
