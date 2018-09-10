package ua.website.editor;

import java.beans.PropertyEditorSupport;

import ua.website.entity.Commodity;
import ua.website.service.CommodityService;

/**
 * This is Editor we use to find specified {@code Commodity}
 * when String-type id of {@code Commodity} comes from form
 * using {@code PropertyEditorSupport} class
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 * @see ua.website.service.CommodityService
 * @see ua.website.controller.admin.CommodityController
 */
public class CommodityEditor extends PropertyEditorSupport{

	/**{@code CommodityService} this class will use*/
	private final CommodityService commodityService;

	/**
	 * Constructor that sets {@code CommodityService} in this object
	 * @param commodityService {@code CommodityService} object
	 */
	public CommodityEditor(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	/**
	 * Finds and sets {@Commodity} by String-type id that comes in parameter
	 * @param text id of {@Commodity} we need
	 * @throws IllegalArgumentException when it's an inappropriate argument
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Commodity commodity = commodityService.findOne(Integer.valueOf(text));
		setValue(commodity);
	}
}
