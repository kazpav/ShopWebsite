package ua.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.entity.Subcategory;
import ua.website.service.SubcategoryService;

public class SubcategoryValidator implements Validator{
	private final SubcategoryService subcategoryService;

	public SubcategoryValidator(SubcategoryService subcategoryService) {
		super();
		this.subcategoryService = subcategoryService;
	}

	public boolean supports(Class<?> clazz){
		return Subcategory.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Subcategory subcategory = (Subcategory) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "can't be empty");
		if(subcategoryService.findByName(subcategory.getName())!=null){
			errors.rejectValue("name", "", "already exists");
		}
	}
	
	
}
