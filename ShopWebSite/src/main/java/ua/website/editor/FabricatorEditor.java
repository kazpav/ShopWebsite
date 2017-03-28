package ua.website.editor;

import java.beans.PropertyEditorSupport;

import ua.website.entity.Fabricator;
import ua.website.service.FabricatorService;

public class FabricatorEditor extends PropertyEditorSupport{
	private final FabricatorService fabricatorService;

	public FabricatorEditor(FabricatorService fabricatorService) {
		this.fabricatorService = fabricatorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Fabricator fabricator = fabricatorService.findOne(Integer.valueOf(text));
		setValue(fabricator);
	}
	
	
}
