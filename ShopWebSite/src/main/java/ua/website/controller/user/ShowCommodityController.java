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
import ua.website.validator.ShowCommodityValidator;

/**
 * Controller that will be called on {/commodity/{id}} page;
 * showing {@code Commodity} will al it's fields
 * that can be added to basket
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.User
 * @see ua.website.entity.Commodity
 * @see ua.website.entity.Category
 * @see ua.website.entity.UserCommodity
 * @see ua.website.service.CategoryService
 * @see ua.website.service.CommodityService
 * @see ua.website.service.UserService
 * @see ua.website.service.UserCommodityService
 * @see ua.website.dto.form.UserCommodityForm
 * @see ua.website.validator.ShowCommodityValidator
 * @see ua.website.editor.UserEditor
 * @see ua.website.editor.CommodityEditor
 */
@Controller
@RequestMapping("/commodity/{id}")
public class ShowCommodityController {

	/** Injected {@code CommodityService} used in this Controller*/
	@Autowired
	private CommodityService commodityService;

	/** Injected {@code UserService} used in this Controller*/
	@Autowired
	private UserService userService;

	/** Injected {@code UserCommodityService} used in this Controller*/
	@Autowired
	private UserCommodityService userCommodityService;

	/** Injected {@code CategoryService} used in this Controller*/
	@Autowired
	private CategoryService categoryService;

	/**
	 * This method binds validator and editors we use on this page
	 * @param binder binder we use
	 */
	@InitBinder("form")
	protected void binder(WebDataBinder binder){
		binder.registerCustomEditor(User.class, new UserEditor(userService));
		binder.registerCustomEditor(Commodity.class, new CommodityEditor(commodityService));
		binder.setValidator(new ShowCommodityValidator(userCommodityService));
	}

	/**
	 * This method creates and returns new empty {@code UserCommodityForm} entity
	 * @return new {@code UserCommodityForm}
	 */
	@ModelAttribute("form")
	public UserCommodityForm getForm() {
		return new UserCommodityForm();
	}

	/**
	 * This method gets all Entities we need on this page
	 * @param id {@code Commodity}'s id we need
	 * @param model model we use
	 * @return redirect link
	 */
	@GetMapping
	public String show(@PathVariable int id, Model model) {
		model.addAttribute("commodity", commodityService.findOne(id));
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("status_inbasket", SaleStatus.STATUS_INBASKET);
		return "user-commodity";
	}

	/**
	 * This method adds {@code Commodity} to {@code User}'s basket
	 * creating {@code UserCommodity} object
	 * @param userCommodity {@code UserCommodity} we create
	 * @param br {@code BindingResult} to check validator errors
	 * @param model model we use
	 * @param principal {@code Principal} object to identify {@code User}
	 * @param id {@code Commodity}'s id chosen by {@code User}
	 * @return
	 */
	@PostMapping
	public String addToBasket(
			@ModelAttribute("form")@Valid UserCommodityForm userCommodity,BindingResult br,
			Model model, Principal principal, @PathVariable int id){
		if (principal != null) {
			if(br.hasErrors()) return show(id,model);
			Commodity comm = userCommodity.getCommodity();
			if(userCommodityService.findUnique(userCommodity.getUser().getId(), userCommodity.getCommodity().getId(), userCommodity.getStatus())!=null){
				UserCommodity uc = userCommodityService.findUnique(userCommodity.getUser().getId(), userCommodity.getCommodity().getId(),userCommodity.getStatus());
				uc.setNumber(uc.getNumber()+Integer.parseInt(userCommodity.getNumber()));
				System.out.println(uc.getId());
				System.out.println(uc.getNumber());	
				System.out.println(Integer.parseInt(userCommodity.getNumber()));
				userCommodityService.save(uc);
			}else{
				userCommodityService.saveForm(userCommodity);
			}
			comm.setQuantity(comm.getQuantity()-Integer.parseInt(userCommodity.getNumber()));
			commodityService.save(comm);
		}
		return "redirect:/commodity/{id}";
	}
}
