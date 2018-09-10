package ua.website.editor;

import java.beans.PropertyEditorSupport;

import ua.website.entity.Subcategory;
import ua.website.service.SubcategoryService;

/**
 * This is Editor we use to find specified {@code Subcategory}
 * when String-type id of {@code Subcategory} comes from form
 * using {@code PropertyEditorSupport} class
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Subcategory
 * @see ua.website.service.SubcategoryService
 * @see ua.website.controller.admin.SubcategoryController
 */
public class SubcategoryEditor extends PropertyEditorSupport{

	/**{@code SubcategoryService} this class will use*/
	SubcategoryService subcategoryService;

	/**
	 * Constructor that sets {@code SubcategoryService} in this object
	 * @param subcategoryService {@code SubcategoryService} object
	 */
	public SubcategoryEditor(SubcategoryService subcategoryService) {
		super();
		this.subcategoryService = subcategoryService;
	}

	/**
	 * Finds and sets {@Subcategory} by String-type id that comes in parameter
	 * @param text id of {@Subcategory} we need
	 * @throws IllegalArgumentException when it's an inappropriate argument
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Subcategory subcategory = subcategoryService.findOne(Integer.valueOf(text));
		setValue(subcategory);
		
	}
	
	
	
	
}
