package ua.website.editor;

import java.beans.PropertyEditorSupport;

import ua.website.entity.Fabricator;
import ua.website.service.FabricatorService;

/**
 * This is Editor we use to find specified {@code Fabricator}
 * when String-type id of {@code Fabricator} comes from form
 * using {@code PropertyEditorSupport} class
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Fabricator
 * @see ua.website.service.FabricatorService
 * @see ua.website.controller.admin.FabricatorController
 */
public class FabricatorEditor extends PropertyEditorSupport{

	/**{@code FabricatorService} this class will use*/
	private final FabricatorService fabricatorService;

	/**
	 * Constructor that sets {@code FabricatorService} in this object
	 * @param fabricatorService {@code FabricatorService} object
	 */
	public FabricatorEditor(FabricatorService fabricatorService) {
		this.fabricatorService = fabricatorService;
	}

	/**
	 * Finds and sets {@Fabricator} by String-type id that comes in parameter
	 * @param text id of {@Fabricator} we need
	 * @throws IllegalArgumentException when it's an inappropriate argument
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Fabricator fabricator = fabricatorService.findOne(Integer.valueOf(text));
		setValue(fabricator);
	}
	
	
}
