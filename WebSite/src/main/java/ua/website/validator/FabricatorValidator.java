package ua.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.entity.Fabricator;
import ua.website.service.FabricatorService;

public class FabricatorValidator implements Validator{
	private final FabricatorService fabricatorService;
	
	public FabricatorValidator(FabricatorService fabricatorService) {
		this.fabricatorService = fabricatorService;
	}

	
	
	public boolean supports(Class<?> clazz) {
		return Fabricator.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Fabricator fabricator = (Fabricator) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"can't be empty");
		if(fabricatorService.findByName(fabricator.getName())!=null){
			errors.rejectValue("name", "", "already exists");
		}
	}
	
}
