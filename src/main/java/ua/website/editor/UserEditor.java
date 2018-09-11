package ua.website.editor;

import java.beans.PropertyEditorSupport;

import ua.website.entity.User;
import ua.website.service.UserService;

/**
 * This is Editor we use to find specified {@code User}
 * when String-type id of {@code User} comes from form
 * using {@code PropertyEditorSupport} class
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.User
 * @see ua.website.service.UserService
 */
public class UserEditor extends PropertyEditorSupport{

	/**{@code UserService} this class will use*/
	private final UserService userService;

	/**
	 * Constructor that sets {@code UserService} in this object
	 * @param userService {@code UserService} object
	 */
	public UserEditor(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Finds and sets {@User} by String-type id that comes in parameter
	 * @param text id of {@User} we need
	 * @throws IllegalArgumentException when it's an inappropriate argument
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = userService.findOne(Integer.valueOf(text));
		setValue(user);
	}
}
