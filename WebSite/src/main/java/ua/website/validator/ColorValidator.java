package ua.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.entity.Color;
import ua.website.service.ColorService;

public class ColorValidator implements Validator{

	private final ColorService colorService;
	
	
	
	public ColorValidator(ColorService colorService) {
		this.colorService = colorService;
	}

	public boolean supports(Class<?> clazz) {
		return Color.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Color color = (Color) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "can't be empty");
		if(colorService.findByName(color.getName())!=null){
			errors.rejectValue("name","", "already exists");
		}
	}

}
