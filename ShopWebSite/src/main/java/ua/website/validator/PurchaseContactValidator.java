package ua.website.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.dto.form.PurchaseContactForm;
import ua.website.service.PurchaseContactService;

/**
 * This class validates @{PurchaseContact} entities
 * using Spring Framework's Validator interface
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.PurchaseContact
 * @see ua.website.service.PurchaseContactService
 */
public class PurchaseContactValidator implements Validator {

	/** {@code PurchaseContactService} object that will be used during validation*/
	private final PurchaseContactService purchaseContactService;

	/** RegEx that will be used during validation */
	private static final Pattern REG = Pattern.compile("^([0-9]{1,17})$");

	/**
	 * Constructor, that sets {@code PurchaseContactService} object
	 * @param purchaseContactService {@code PurchaseContactService} object
	 */
	public PurchaseContactValidator(
			PurchaseContactService purchaseContactService) {
		this.purchaseContactService = purchaseContactService;
	}

	/**
	 * Checks if parameter is an appropriate type
	 * @param clazz class you want to check
	 * @return {@code true} if this object is the same type
	 * as the object argument; {@code false} otherwise
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseContactForm.class.equals(clazz);
	}

	/**
	 * This method validates {@code PurchaseContact} objects
	 * @param target {@code PurchaseContact} object you want to validate
	 * @param errors possible errors
	 */
	@Override
	public void validate(Object target, Errors errors) {
		PurchaseContactForm form = (PurchaseContactForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "",
				"Can't be empty");
		if(!REG.matcher(form.getContactNumber()).matches()){
			errors.rejectValue("contactNumber", "", "User numbers pls");
		}
	}

}
