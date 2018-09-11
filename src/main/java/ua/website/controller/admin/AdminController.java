package ua.website.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller that will be called on {/admin} link;
 * this is empty page, where admin can go to other tabs
 * @author Pavel Kazarin
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	/** Shows empty page */
	@GetMapping
	public String show(){
		return "admin-admin";
	}
}
