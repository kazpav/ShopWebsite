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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.website.entity.User;
import ua.website.service.MailSendingService;
import ua.website.service.UserService;
import ua.website.validator.UserValidator;


@Controller
@SessionAttributes("user")
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UserService userService;
	@Autowired 
	private MailSendingService mailSendingService;

	@InitBinder("user")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new UserValidator(userService));
	}
	
	@GetMapping
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "user-registration";
	}
	
	@PostMapping
	public String save(@ModelAttribute("user") @Valid User user,
			BindingResult br, Model model, SessionStatus sessionStatus) {
		if (br.hasErrors())
			return "user-registration";
		userService.save(user);
		mailSendingService.sendMail("Welcome to our shop", user.getEmail(), "Thanks for choosing our shop for buying equipment.");
		sessionStatus.setComplete();
		return "redirect:/login";
	}
}
