package ua.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.entity.Country;
import ua.website.service.CountryService;

/**
 * This class validates @{Country} entities
 * using Spring Framework's Validator interface
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Country
 * @see ua.website.service.CountryService
 * @see ua.website.controller.admin.CountryController
 */
public class CountryValidator implements Validator{

	/** {@code CountryService} object that will be used during validation*/
	private final CountryService countryService;

	/**
	 * Constructor, that sets {@code CountryService} object
	 * @param countryService {@code CountryService} object
	 */
	public CountryValidator(CountryService countryService) {
		this.countryService = countryService;
	}

	/**
	 * Checks if parameter is an appropriate type
	 * @param clazz class you want to check
	 * @return {@code true} if this object is the same type
	 * as the object argument; {@code false} otherwise
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Country.class.equals(clazz);
	}

	/**
	 * This method validates {@code Commodity} objects
	 * @param target {@code Commodity} object you want to validate
	 * @param errors possible errors
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Country country = (Country) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "can't be empty");
		if(countryService.findByName(country.getName())!=null){
			errors.rejectValue("name", "", "already exists");
		}
	}
	
	
}
