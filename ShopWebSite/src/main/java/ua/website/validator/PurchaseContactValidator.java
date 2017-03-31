package ua.website.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.dto.form.PurchaseContactForm;
import ua.website.service.PurchaseContactService;

public class PurchaseContactValidator implements Validator {

	private final PurchaseContactService purchaseContactService;

	private static final Pattern REG = Pattern.compile("^([0-9]{1,17})$");

	public PurchaseContactValidator(
			PurchaseContactService purchaseContactService) {
		this.purchaseContactService = purchaseContactService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseContactForm.class.equals(clazz);
	}

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
