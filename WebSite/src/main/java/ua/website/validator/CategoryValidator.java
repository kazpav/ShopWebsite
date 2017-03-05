package ua.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.entity.Category;
import ua.website.service.CategoryService;

public class CategoryValidator implements Validator {
	private final CategoryService categoryService;

	public CategoryValidator(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public boolean supports(Class<?> clazz) {
		return Category.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Category category = (Category) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"can't be empty");
		if (categoryService.findByName(category.getName()) != null) {
			errors.rejectValue("name", "", "already exists");
		}
	}

}
