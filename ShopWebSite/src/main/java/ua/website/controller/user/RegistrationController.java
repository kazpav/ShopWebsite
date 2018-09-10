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


/**
 * Controller that will be called on {/registration} link;
 * register new {@code User}'s
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.User
 * @see ua.website.service.UserService
 * @see ua.website.service.MailSendingService
 * @see ua.website.validator.UserValidator
 */
@Controller
@SessionAttributes("user")
@RequestMapping("/registration")
public class RegistrationController {

	/** Injected {@code UserService} used in this Controller*/
	@Autowired
	private UserService userService;

	/** Injected {@code MailSendingService} used in this Controller*/
	@Autowired 
	private MailSendingService mailSendingService;

	/** Binds validator for {@code User} objects */
	@InitBinder("user")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new UserValidator(userService));
	}


	/**
	 * This method adds new {@code User} as attribute to model
	 * @param model model we use
	 * @return redirect link
	 */
	@GetMapping
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "user-registration";
	}

	/**
	 * This method saves new {@code User} using Post method
	 * and sends email to this new {@code User}
	 * @param user {@code User} to save
	 * @param br {@code BindingResult} used to check validation
	 * @param model model we use
	 * @param sessionStatus Session Status
	 * @return redirect link
	 */
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
