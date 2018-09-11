package ua.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.entity.Fabricator;
import ua.website.service.FabricatorService;

/**
 * This class validates @{Fabricator} entities
 * using Spring Framework's Validator interface
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Fabricator
 * @see ua.website.service.FabricatorService
 * @see ua.website.controller.admin.FabricatorController
 */
public class FabricatorValidator implements Validator{

	/** {@code FabricatorService} object that will be used during validation*/
	private final FabricatorService fabricatorService;

	/**
	 * Constructor, that sets {@code FabricatorService} object
	 * @param fabricatorService {@code FabricatorService} object
	 */
	public FabricatorValidator(FabricatorService fabricatorService) {
		this.fabricatorService = fabricatorService;
	}

	/**
	 * Checks if parameter is an appropriate type
	 * @param clazz class you want to check
	 * @return {@code true} if this object is the same type
	 * as the object argument; {@code false} otherwise
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Fabricator.class.equals(clazz);
	}

	/**
	 * This method validates {@code Commodity} objects
	 * @param target {@code Commodity} object you want to validate
	 * @param errors possible errors
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Fabricator fabricator = (Fabricator) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"can't be empty");
		if(fabricatorService.findByName(fabricator.getName())!=null){
			errors.rejectValue("name", "", "already exists");
		}
	}
	
}
