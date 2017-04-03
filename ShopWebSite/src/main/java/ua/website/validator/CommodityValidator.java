package ua.website.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.dto.form.CommodityForm;
import ua.website.service.CommodityService;

public class CommodityValidator implements Validator{
	
	private static final Pattern REG = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	
	private final CommodityService commodityService;

	public CommodityValidator(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public boolean supports(Class<?> clazz) {
		return CommodityForm.class.equals(clazz);
	}

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
