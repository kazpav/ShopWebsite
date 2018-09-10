package ua.website.editor;

import java.beans.PropertyEditorSupport;

import ua.website.entity.Color;
import ua.website.service.ColorService;

/**
 * This is Editor we use to find specified {@code Color}
 * when String-type id of {@code Color} comes from form
 * using {@code PropertyEditorSupport} class
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Color
 * @see ua.website.service.ColorService
 * @see ua.website.controller.admin.ColorController
 */
public class ColorEditor extends PropertyEditorSupport{

	/**{@code ColorService} this class will use*/
	private final ColorService colorService;

	/**
	 * Constructor that sets {@code ColorService} in this object
	 * @param colorService {@code ColorService} object
	 */
	public ColorEditor(ColorService colorService) {
		this.colorService = colorService;
	}

	/**
	 * Finds and sets {@Color} by String-type id that comes in parameter
	 * @param text id of {@Color} we need
	 * @throws IllegalArgumentException when it's an inappropriate argument
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Color color = colorService.findOne(Integer.valueOf(text));
		setValue(color);
	}
	
}
