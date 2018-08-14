package ua.website.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.dto.form.CommodityForm;
import ua.website.service.CommodityService;

/**
 * This class validates @{Commodity} entities
 * using Spring Framework's Validator interface
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 * @see ua.website.service.CommodityService
 * @see ua.website.controller.admin.CommodityController
 * @see ua.website.dto.form.CommodityForm
 */
public class CommodityValidator implements Validator{

	/** RegEx that will be used during validation */
	private static final Pattern REG = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");

	/** {@code CommodityService} object that will be used during validation*/
	private final CommodityService commodityService;

	/**
	 * Constructor, that sets {@code CommodityService} object
	 * @param commodityService {@code CommodityService} object
	 */
	public CommodityValidator(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	/**
	 * Checks if parameter is an appropriate type
	 * @param clazz class you want to check
	 * @return {@code true} if this object is the same type
	 * as the object argument; {@code false} otherwise
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return CommodityForm.class.equals(clazz);
	}

	/**
	 * This method validates {@code CommodityForm} objects
	 * @param target {@code CommodityForm} object you want to validate
	 * @param errors possible errors
	 */
	@Override
	public void validate(Object target, Errors errors) {
		CommodityForm form = (CommodityForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "name can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "", "description can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "", "price can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "", "quantity can't be empty");
		if(!REG.matcher(form.getPrice()).matches()){
			errors.rejectValue("price", "", "Must be separated by . or , also only numbers");
		}else if(form.getFile()==null){
			errors.rejectValue("file", "", "You forgot about picture");
		}
	}

}
