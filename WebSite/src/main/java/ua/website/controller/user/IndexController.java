package ua.website.controller.user;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.website.entity.User;
import ua.website.service.CategoryService;
import ua.website.service.CommodityService;
import ua.website.service.CountryService;
import ua.website.service.UserService;


@Controller
public class IndexController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CountryService countryService;
	
	
	
	@RequestMapping("/")
	public String index(Model model/*, Principal principal*/){
//		if(principal!=null){
//			System.out.println(principal.getName());
//		}
		model.addAttribute("categories", categoryService.findAll());
		return "user-index";
	}
	
	
//	@RequestMapping(value="/registration", method=RequestMethod.POST)
//	public String registration(@RequestParam String name, @RequestParam String country,
//			@RequestParam String email, @RequestParam String password){
//		userService.save(new User(name, email, password));
//		
//		
//		return "user-registration";
//		
//		
//	}
//	
//	@RequestMapping("/")
//	public String index(){
//		return "user-index";
//	}
//	
	@RequestMapping("/page1")
	public String page1(){
		return "user-page1";
	}
	
	@RequestMapping("/page2")
	public String page2(){
		return "user-page2";
	}
	@RequestMapping("/page3")
	public String page3(){
		return "user-page3";
	}
	@RequestMapping("/page4")
	public String page4(){
		return "user-page4";
	}
	@RequestMapping("/page5")
	public String page5(){
		return "user-page5";
	}
}
