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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.website.dto.form.UserCommodityForm;
import ua.website.editor.CommodityEditor;
import ua.website.editor.UserEditor;
import ua.website.entity.Commodity;
import ua.website.entity.User;
import ua.website.entity.UserCommodity;
import ua.website.service.CategoryService;
import ua.website.service.CommodityService;
import ua.website.service.UserCommodityService;
import ua.website.service.UserService;
import ua.website.validator.ShowCommodityValidator;

@Controller
@RequestMapping("/commodity/{id}")
//@SessionAttributes("form")
public class ShowCommodityController {

	@Autowired
	private CommodityService commodityService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserCommodityService userCommodityService;
	@Autowired
	private CategoryService categoryService;

	@InitBinder("form")
	protected void binder(WebDataBinder binder){
		binder.registerCustomEditor(User.class, new UserEditor(userService));
		binder.registerCustomEditor(Commodity.class, new CommodityEditor(commodityService));
		binder.setValidator(new ShowCommodityValidator(userCommodityService));
	}
	
	
	@ModelAttribute("form")
	public UserCommodityForm getForm() {
		return new UserCommodityForm();
	}

	@GetMapping
	public String show(@PathVariable int id, Model model) {
		model.addAttribute("commodity", commodityService.findOne(id));
		model.addAttribute("categories", categoryService.findAll());

		return "user-commodity";
	}

	@PostMapping
	public String addToBasket(
			@ModelAttribute("form")@Valid UserCommodityForm userCommodity,BindingResult br,
			Model model, Principal principal, @PathVariable int id){
		if (principal != null) {

			if(br.hasErrors()) return show(id,model);
			Commodity comm = userCommodity.getCommodity();
			if(userCommodityService.findUnique(userCommodity.getUser().getId(), userCommodity.getCommodity().getId())!=null){
				UserCommodity uc = userCommodityService.findUnique(userCommodity.getUser().getId(), userCommodity.getCommodity().getId());
				uc.setNumber(uc.getNumber()+Integer.parseInt(userCommodity.getNumber()));
				System.out.println(uc.getId());
				System.out.println(uc.getNumber());	
				System.out.println(Integer.parseInt(userCommodity.getNumber()));
				userCommodityService.save(uc);
				
				
			}else{
				userCommodityService.saveForm(userCommodity);
			}
//			commodity.setQuantity(commodity.getQuantity()-Integer.parseInt(userCommodity.getNumber()));
			comm.setQuantity(comm.getQuantity()-Integer.parseInt(userCommodity.getNumber()));
			commodityService.save(comm);
			
		}
		
		return "redirect:/commodity/{id}";
	}
}
