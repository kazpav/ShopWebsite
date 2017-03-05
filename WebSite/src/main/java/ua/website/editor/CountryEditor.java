package ua.website.editor;

import java.beans.PropertyEditorSupport;

import ua.website.entity.Country;
import ua.website.service.CountryService;

public class CountryEditor extends PropertyEditorSupport {
	private final CountryService countryService;

	public CountryEditor(CountryService countryService) {
		super();
		this.countryService = countryService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Country country = countryService.findOne(Integer.valueOf(text));
		setValue(country);
	}
	
	
}
