package ua.website.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.website.entity.Category;
import ua.website.service.CategoryService;


@Controller
public class DataBaseModerController {

//	@Autowired
//	private CategoryService categoryService;
//	
//	@RequestMapping(value="/categoryModer", method=RequestMethod.POST)
//	public String saveCategory(@RequestParam(value="saveCateg") String name){
//		categoryService.save(new Category(name));
//		return "redirect:/admin/categoryModer";
//	}
//	@RequestMapping(value="categoryModer", method=RequestMethod.POST)
//	public List<Category> findAllCateg(){
//		List<Category> catlist = categoryService.findAll();
//		return categoryService.findAll();
//	}
//	@RequestMapping(value="/categoryModer", method=RequestMethod.POST)
//	public String findOneCategory(@RequestParam(value="findOneCateg") int id){
//		categoryService.findOne(id);
//		return "redirect:/admin/categoryModer";
//	}
//	@RequestMapping(value="/categoryModer", method=RequestMethod.POST)
//	public String deleteCategory(@RequestParam(value="deleteCateg") int id){
//		categoryService.delete(id);
//		return "redirect:/admin/categoryModer";
//	}
//	
	@RequestMapping("WebSite/startPage")
	public String startPage(){
		return "admin-startPage";
	}
//	
//	@RequestMapping("/categoryModer")
//	public String categoryModer(){
//		return "admin-categoryModer";
//	}
//	@RequestMapping("/colorModer")
//	public String colorModer(){
//		return "admin-colorModer";
//	}
//
//	@RequestMapping("/commodityModer")
//	public String commodityModer(){
//		return "admin-commodityModer";
//	}
//	@RequestMapping("/countryModer")
//	public String countryModer(){
//		return "admin-countryModer";
//	}
//	@RequestMapping("/fabricatorModer")
//	public String fabricatorModer(){
//		return "admin-fabricatorModer";
//	}
//	@RequestMapping("/subcategModer")
//	public String subcategModer(){
//		return "admin-subcategModer";
//	}
//	@RequestMapping("/userModer")
//	public String userModer(){
//		return "admin-userModer";
//	}
}
