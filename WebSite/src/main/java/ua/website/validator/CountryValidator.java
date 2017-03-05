package ua.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.entity.Country;
import ua.website.service.CountryService;

public class CountryValidator implements Validator{
	private final CountryService countryService;
	
	public CountryValidator(CountryService countryService) {
		this.countryService = countryService;
	}

	public boolean supports(Class<?> clazz) {
		return Country.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Country country = (Country) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "can't be empty");
		if(countryService.findByName(country.getName())!=null){
			errors.rejectValue("name", "", "already exists");
		}
	}
	
	
}
