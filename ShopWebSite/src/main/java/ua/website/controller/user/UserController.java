package ua.website.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.website.service.UserService;

/**
 * This method is needed for displaying {/login} page.
 * All login logic is realised by Spring Security
 * @author Pavel Kazarin
 * @version 1.0
 */
@Controller
public class UserController {

	/** Injected {@code UserService} used in this Controller*/
	@Autowired
	private UserService userService;

	/** Method for displaying page */
	@GetMapping("/login")
	public String login() {
		return "user-login";
	}

}
