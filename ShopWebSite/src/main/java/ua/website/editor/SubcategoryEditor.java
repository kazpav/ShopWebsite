package ua.website.editor;

import java.beans.PropertyEditorSupport;

import ua.website.entity.Subcategory;
import ua.website.service.SubcategoryService;

public class SubcategoryEditor extends PropertyEditorSupport{
	SubcategoryService subcategoryService;

	public SubcategoryEditor(SubcategoryService subcategoryService) {
		super();
		this.subcategoryService = subcategoryService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Subcategory subcategory = subcategoryService.findOne(Integer.valueOf(text));
		setValue(subcategory);
		
	}
	
	
	
	
}
