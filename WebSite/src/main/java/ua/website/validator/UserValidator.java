package ua.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.entity.User;
import ua.website.service.UserService;

public class UserValidator implements Validator {

	private final UserService userService;

	private static final int MINIMUM_PASSWORD_LENGTH = 6;

	public UserValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "name", "", "can't be empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "", "can't be empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "", "can't be empty");
		if (userService.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "",
					"User with such email already exists");
		}
		if (user.getPassword() != null
				&& user.getPassword().trim().length() < MINIMUM_PASSWORD_LENGTH) {
			errors.rejectValue("password", "",
					new Object[] { Integer.valueOf(MINIMUM_PASSWORD_LENGTH) },
					"The password must be at least " + MINIMUM_PASSWORD_LENGTH
							+ " characters in length.");
		}
		//input текстовий для - відправлення
		//transient
		
	}

}
