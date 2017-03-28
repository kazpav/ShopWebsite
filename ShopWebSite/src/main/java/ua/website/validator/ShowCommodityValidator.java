package ua.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.website.dto.form.UserCommodityForm;
import ua.website.service.UserCommodityService;

public class ShowCommodityValidator implements Validator{

	private final UserCommodityService userCommodityService;
	
	
	
	public ShowCommodityValidator(UserCommodityService userCommodityService) {
		this.userCommodityService = userCommodityService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return UserCommodityForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserCommodityForm form = (UserCommodityForm) target;
		if(form.getCommodity().getQuantity()-Integer.parseInt(form.getNumber())<0){
			errors.rejectValue("number", "", "No such quantity of this item in stock");
		}
	}

}
