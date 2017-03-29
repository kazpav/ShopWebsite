package ua.website.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.website.dto.form.UserCommodityForm;
import ua.website.service.UserCommodityService;

public class ShowCommodityValidator implements Validator{

	private final UserCommodityService userCommodityService;
	

	private static final Pattern REG = Pattern.compile("^([0-9]{1,17})$");
	
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
		if(!REG.matcher(form.getNumber()).matches()|| form.getNumber().equals("0")){
			errors.rejectValue("number", "", "stop breaking my code -_-");
		}else if(form.getCommodity().getQuantity()-Integer.parseInt(form.getNumber())<0){
			errors.rejectValue("number", "", "No such quantity of this item in stock");
		}
		
	}

}