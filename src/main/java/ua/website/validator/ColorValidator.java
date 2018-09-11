package ua.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.entity.Color;
import ua.website.service.ColorService;

/**
 * This class validates @{Color} entities
 * using Spring Framework's Validator interface
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Color
 * @see ua.website.service.ColorService
 * @see ua.website.controller.admin.ColorController
 */
public class ColorValidator implements Validator{

	/** {@code ColorService} object that will be used during validation*/
	private final ColorService colorService;

	/**
	 * Constructor, that sets {@code ColorService} object
	 * @param colorService {@code ColorService} object
	 */
	public ColorValidator(ColorService colorService) {
		this.colorService = colorService;
	}

	/**
	 * Checks if parameter is an appropriate type
	 * @param clazz class you want to check
	 * @return {@code true} if this object is the same type
	 * as the object argument; {@code false} otherwise
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Color.class.equals(clazz);
	}

	/**
	 * This method validates {@code Color} objects
	 * @param target {@code Color} object you want to validate
	 * @param errors possible errors
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Color color = (Color) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "can't be empty");
		if(colorService.findByName(color.getName())!=null){
			errors.rejectValue("name","", "already exists");
		}
	}

}
