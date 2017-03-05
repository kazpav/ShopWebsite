package ua.website.controller.admin;


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

import ua.website.entity.Color;
import ua.website.service.ColorService;
import ua.website.validator.ColorValidator;

@Controller
@RequestMapping("/admin/colorModer")
@SessionAttributes("color")
public class ColorController {

	@Autowired
	private ColorService colorService;
	
	@InitBinder("color")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new ColorValidator(colorService));
	}
	
	
	@ModelAttribute("color")
	public Color getForm(){
		return new Color();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("colors", colorService.findAll());
		return "admin-colorModer";
	}
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("color", colorService.findOne(id));
		show(model);
		return "admin-colorModer";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		colorService.delete(id);
		return "redirect:/admin/colorModer";
	}
	@PostMapping
	public String save(@ModelAttribute("color")@Valid Color color,BindingResult br,
			Model model,SessionStatus status){
		if(br.hasErrors()) return show(model);
		
		colorService.save(color);
		status.setComplete();
		
		
		return "redirect:/admin/colorModer";
	}
}