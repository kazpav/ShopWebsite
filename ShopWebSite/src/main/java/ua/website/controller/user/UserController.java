package ua.website.controller.user;

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

import ua.website.entity.User;
import ua.website.service.UserService;
import ua.website.validator.UserValidator;


@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@InitBinder("user")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new UserValidator(userService));
	}
	
	@GetMapping("/registration")
	public String registration(Model model){
		model.addAttribute("user",new User());
		return "user-registration";
	}
	
	@PostMapping("/registration")
	public String save(@ModelAttribute("user")@Valid User user, BindingResult br,
			Model model){
		if(br.hasErrors()) return "user-registration";
		userService.save(user);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(){
		return "user-login";
	}
}
