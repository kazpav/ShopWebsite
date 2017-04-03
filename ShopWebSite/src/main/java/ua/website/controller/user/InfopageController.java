package ua.website.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.website.service.CategoryService;

@Controller
@RequestMapping("/infopage")
public class InfopageController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("categories", categoryService.findAll());
		return "user-infopage";
	}
}
