package ua.website.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.website.dto.form.UserCommodityForm;
import ua.website.entity.UserCommodity;
import ua.website.service.UserCommodityService;

public class BasketValidator implements Validator{

	private final UserCommodityService userCommodityService;

	private static final Pattern REG = Pattern.compile("^([0-9]{1,17})$");
	
	
	public BasketValidator(UserCommodityService userCommodityService) {
		this.userCommodityService = userCommodityService;
	}

	@Override
	public boolean supports(Class<?> clazz) {	
		return UserCommodityForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserCommodityForm form = (UserCommodityForm) target;
		UserCommodity uc = userCommodityService.findUnique(form.getUser().getId(), form.getCommodity().getId(), form.getStatus());
		if(!REG.matcher(form.getNumber()).matches()|| form.getNumber().equals("0")){
			errors.rejectValue("number", "", "Nope. Use numbers. Also can't be 0");
		} else
		if (form.getCommodity().getQuantity()+uc.getNumber()-Integer.parseInt(form.getNumber())<0) {
			errors.rejectValue("number", "", "No such quantity of this item in stock");
		}
	}

}
