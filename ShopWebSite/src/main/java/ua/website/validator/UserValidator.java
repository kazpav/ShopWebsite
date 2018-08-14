package ua.website.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.website.entity.User;
import ua.website.service.UserService;

/**
 * This class validates @{User} entities
 * using Spring Framework's Validator interface
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.User
 * @see ua.website.service.UserService
 * @see ua.website.controller.user.RegistrationController
 */
public class UserValidator implements Validator {

	/** {@code UserService} object that will be used during validation*/
	private final UserService userService;

	/** Constant representing minimum length of password*/
	private static final int MINIMUM_PASSWORD_LENGTH = 6;

	/**
	 * Constructor, that sets {@code UserService} object
	 * @param userService {@code UserService} object
	 */
	public UserValidator(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Checks if parameter is an appropriate type
	 * @param clazz class you want to check
	 * @return {@code true} if this object is the same type
	 * as the object argument; {@code false} otherwise
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	/**
	 * This method validates {@code User} objects
	 * @param target {@code User} object you want to validate
	 * @param errors possible errors
	 */
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
		if(!user.getPassword().equals(user.getRepeatPassword())){
			errors.rejectValue("password", "", "Password field and repeat password field are not equals");
			System.out.println(user.getPassword());
			System.out.println(user.getRepeatPassword());
		}
	}

}
