package ua.website.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.website.dto.form.UserCommodityForm;
import ua.website.service.UserCommodityService;

/**
 * This class validates @{UserCommodity} entities
 * using Spring Framework's Validator interface
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.UserCommodity
 * @see ua.website.service.UserCommodityService
 */
public class ShowCommodityValidator implements Validator{

	/** {@code UserCommodityService} object that will be used during validation*/
	private final UserCommodityService userCommodityService;

	/** RegEx that will be used during validation*/
	private static final Pattern REG = Pattern.compile("^([0-9]{1,17})$");

	/**
	 * Constructor, that sets {@code UserCommodityService} object
	 * @param userCommodityService {@code UserCommodityService} object
	 */
	public ShowCommodityValidator(UserCommodityService userCommodityService) {
		this.userCommodityService = userCommodityService;
	}

	/**
	 * Checks if parameter is an appropriate type
	 * @param clazz class you want to check
	 * @return {@code true} if this object is the same type
	 * as the object argument; {@code false} otherwise
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return UserCommodityForm.class.equals(clazz);
	}

	/**
	 * This method validates {@code UserCommodity} objects
	 * @param target {@code UserCommodity} object you want to validate
	 * @param errors possible errors
	 */
	@Override
	public void validate(Object target, Errors errors) {
		UserCommodityForm form = (UserCommodityForm) target;
		if(!REG.matcher(form.getNumber()).matches()|| form.getNumber().equals("0")){
			errors.rejectValue("number", "", "stop breaking my code -_-");
		}else if(form.getCommodity().getQuantity()-Integer.parseInt(form.getNumber())<0){
			errors.rejectValue("number", "", "No such quantity of this item in stock");
		}
		
	}

}
