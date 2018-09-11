package ua.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.entity.Category;
import ua.website.service.CategoryService;

/**
 * This class validates @{Category} entities
 * using Spring Framework's Validator interface
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Category
 * @see ua.website.service.CategoryService
 * @see ua.website.controller.admin.CategoryController
 */
public class CategoryValidator implements Validator {

	/** {@code CategoryService} object that will be used during validation*/
	private final CategoryService categoryService;

	/**
	 * Constructor, that sets {@code CategoryService} object
	 * @param categoryService {@code CategoryService} object
	 */
	public CategoryValidator(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * Checks if parameter is an appropriate type
	 * @param clazz class you want to check
	 * @return {@code true} if this object is the same type
	 * as the object argument; {@code false} otherwise
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Category.class.equals(clazz);
	}

	/**
	 * This method validates {@code Category} objects
	 * @param target {@code Category} object you want to validate
	 * @param errors possible errors
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Category category = (Category) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"can't be empty");
		if (categoryService.findByName(category.getName()) != null) {
			errors.rejectValue("name", "", "already exists");
		}
	}

}
