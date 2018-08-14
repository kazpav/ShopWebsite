package ua.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.entity.Subcategory;
import ua.website.service.SubcategoryService;

/**
 * This class validates @{Subcategory} entities
 * using Spring Framework's Validator interface
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Subcategory
 * @see ua.website.service.SubcategoryService
 * @see ua.website.controller.admin.SubcategoryController
 */
public class SubcategoryValidator implements Validator{

	/** {@code CategoryService} object that will be used during validation*/
	private final SubcategoryService subcategoryService;

	/**
	 * Constructor, that sets {@code SubcategoryService} object
	 * @param subcategoryService {@code SubcategoryService} object
	 */
	public SubcategoryValidator(SubcategoryService subcategoryService) {
		super();
		this.subcategoryService = subcategoryService;
	}

	/**
	 * Checks if parameter is an appropriate type
	 * @param clazz class you want to check
	 * @return {@code true} if this object is the same type
	 * as the object argument; {@code false} otherwise
	 */
	@Override
	public boolean supports(Class<?> clazz){
		return Subcategory.class.equals(clazz);
	}

	/**
	 * This method validates {@code Subcategory} objects
	 * @param target {@code Subcategory} object you want to validate
	 * @param errors possible errors
	 */
	public void validate(Object target, Errors errors) {
		Subcategory subcategory = (Subcategory) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "can't be empty");
		if(subcategoryService.findByName(subcategory.getName())!=null){
			errors.rejectValue("name", "", "already exists");
		}
	}
	
	
}
