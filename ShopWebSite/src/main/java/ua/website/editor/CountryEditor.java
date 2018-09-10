package ua.website.editor;

import java.beans.PropertyEditorSupport;

import ua.website.entity.Country;
import ua.website.service.CountryService;

/**
 * This is Editor we use to find specified {@code Country}
 * when String-type id of {@code Country} comes from form
 * using {@code PropertyEditorSupport} class
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Country
 * @see ua.website.service.CountryService
 * @see ua.website.controller.admin.CountryController
 */
public class CountryEditor extends PropertyEditorSupport {

	/**{@code CountryService} this class will use*/
	private final CountryService countryService;

	/**
	 * Constructor that sets {@code CountryService} in this object
	 * @param countryService {@code CountryService} object
	 */
	public CountryEditor(CountryService countryService) {
		super();
		this.countryService = countryService;
	}

	/**
	 * Finds and sets {@Country} by String-type id that comes in parameter
	 * @param text id of {@Country} we need
	 * @throws IllegalArgumentException when it's an inappropriate argument
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Country country = countryService.findOne(Integer.valueOf(text));
		setValue(country);
	}
	
	
}
