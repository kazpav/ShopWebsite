package ua.website.editor;

import java.beans.PropertyEditorSupport;

import ua.website.entity.Category;
import ua.website.service.CategoryService;

/**
 * This is Editor we use to find specified {@code Category}
 * when String-type id of {@code Category} comes from form
 * using {@code PropertyEditorSupport} class
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Category
 * @see ua.website.service.CategoryService
 * @see ua.website.controller.admin.CategoryController
 */
public class CategoryEditor extends PropertyEditorSupport{

	/**{@code CategoryService} this class will use*/
	private final CategoryService categoryService;

	/**
	 * Constructor that sets {@code CategoryService} in this object
	 * @param categoryService {@code CategoryService} object
	 */
	public CategoryEditor(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * Finds and sets {@Category} by String-type id that comes in parameter
	 * @param text id of {@Category} we need
	 * @throws IllegalArgumentException when it's an inappropriate argument
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Category category = categoryService.findOne(Integer.valueOf(text));
		setValue(category);
	}

}
