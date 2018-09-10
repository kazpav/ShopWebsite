package ua.website.dto.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Transfer Object that you need for filtering {@code Commodity}'s on web page
 * Describes object that comes from filtering form for it's converting in future
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 * @see ua.website.specification.CommoditySpecification
 * @see ua.website.controller.admin.CommodityController
 * @see ua.website.service.CommodityService
 */
public class CommodityFilter {

	/** {@code Commodity} name client is looking for*/
	private String nameSearch = "";

	/** String-type {@code Commodity} minimum price the client is looking for */
	private String min = "";

	/** String-type {@code Commodity} maximum price the client is looking for */
	private String max = "";

	/** BigDecimal-type {@code Commodity} minimum price the client is looking for */
	private BigDecimal minPrice;

	/** String-type {@code Commodity} maximum price the client is looking for */
	private BigDecimal maxPrice;

	/** {@code Country}'s related to {@code Commodity}'s client is looking for*/
	private List<Integer> countryId = new ArrayList<>();

	/** {@code Color}'s related to {@code Commodity}'s client is looking for*/
	private List<Integer> colorId = new ArrayList<>();

	/** {@code Subcategory}'s related to {@code Commodity}'s client is looking for*/
	private List<Integer> subcategoryId = new ArrayList<>();

	/** {@code Category}'s related to {@code Commodity}'s client is looking for*/
	private List<Integer> categoryId = new ArrayList<>();

	/** {@code Fabricator}'s related to {@code Commodity}'s client is looking for*/
	private List<Integer> fabricatorId = new ArrayList<>();


	/**
	 * Getter for {@code CommodityFilter}'s nameSearch
	 * @return this {@code CommodityFilter}'s nameSearch
	 */
	public String getNameSearch() {
		return nameSearch;
	}

	/**
	 * Setter for {@code CommodityFilter}'s nameSearch,
	 * changes this {@code CommodityFilter}'s nameSearch
	 * @param nameSearch this {@code CommodityFilter}'s new nameSearch
	 */
	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}

	/**
	 * Getter for {@code CommodityFilter}'s min String-type price
	 * @return this {@code CommodityFilter}'s min String-type price
	 */
	public String getMin() {
		return min;
	}

	/**
	 * Setter for {@code CommodityFilter}'s min String-type price,
	 * changes this {@code CommodityFilter}'s min String-type price
	 * @param min this {@code CommodityFilter}'s new min String-type price
	 */
	public void setMin(String min) {
		this.min = min;
	}

	/**
	 * Getter for {@code CommodityFilter}'s max String-type price
	 * @return this {@code CommodityFilter}'s max String-type price
	 */
	public String getMax() {
		return max;
	}

	/**
	 * Setter for {@code CommodityFilter}'s max String-type price,
	 * changes this {@code CommodityFilter}'s max String-type price
	 * @param max this {@code CommodityFilter}'s new max String-type price
	 */
	public void setMax(String max) {
		this.max = max;
	}

	/**
	 * Getter for {@code CommodityFilter}'s min price
	 * @return this {@code CommodityFilter}'s min price
	 */
	public BigDecimal getMinPrice() {
		return minPrice;
	}

	/**
	 * Setter for {@code CommodityFilter}'s min price,
	 * changes this {@code CommodityFilter}'s min price
	 * @param minPrice this {@code CommodityFilter}'s new min price
	 */
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}


	/**
	 * Getter for {@code CommodityFilter}'s max price
	 * @return this {@code CommodityFilter}'s max price
	 */
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	/**
	 * Setter for {@code CommodityFilter}'s max price,
	 * changes this {@code CommodityFilter}'s max price
	 * @param maxPrice this {@code CommodityFilter}'s new max price
	 */
	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	/**
	 * Getter for {@code CommodityFilter}'s {@code Country}'s id List
	 * @return this {@code CommodityFilter}'s {@code Country}'s id List
	 */
	public List<Integer> getCountryId() {
		return countryId;
	}

	/**
	 * Setter for {@code CommodityFilter}'s {@code Country}'s id List,
	 * changes this {@code CommodityFilter}'s {@code Country}'s id List
	 * @param countryId this {@code CommodityFilter}'s new {@code Country}'s id List
	 */
	public void setCountryId(List<Integer> countryId) {
		this.countryId = countryId;
	}

	/**
	 * Getter for {@code CommodityFilter}'s {@code Color}'s id List
	 * @return this {@code CommodityFilter}'s {@code Color}'s id List
	 */
	public List<Integer> getColorId() {
		return colorId;
	}

	/**
	 * Setter for {@code CommodityFilter}'s {@code Color}'s id List,
	 * changes this {@code CommodityFilter}'s {@code Color}'s id List
	 * @param colorId this {@code CommodityFilter}'s new {@code Color}'s id List
	 */
	public void setColorId(List<Integer> colorId) {
		this.colorId = colorId;
	}

	/**
	 * Getter for {@code CommodityFilter}'s {@code Subcategory}'s id List
	 * @return this {@code CommodityFilter}'s {@code Subcategory}'s id List
	 */
	public List<Integer> getSubcategoryId() {
		return subcategoryId;
	}

	/**
	 * Setter for {@code CommodityFilter}'s {@code Subcategory}'s id List,
	 * changes this {@code CommodityFilter}'s {@code Subcategory}'s id List
	 * @param subcategoryId this {@code CommodityFilter}'s new {@code Subcategory}'s id List
	 */
	public void setSubcategoryId(List<Integer> subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	/**
	 * Getter for {@code CommodityFilter}'s {@code Category}'s id List
	 * @return this {@code CommodityFilter}'s {@code Category}'s id List
	 */
	public List<Integer> getCategoryId() {
		return categoryId;
	}

	/**
	 * Setter for {@code CommodityFilter}'s {@code Category}'s id List,
	 * changes this {@code CommodityFilter}'s {@code Category}'s id List
	 * @param categoryId this {@code CommodityFilter}'s new {@code Category}'s id List
	 */
	public void setCategoryId(List<Integer> categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Getter for {@code CommodityFilter}'s {@code Fabricator}'s id List
	 * @return this {@code CommodityFilter}'s {@code Fabricator}'s id List
	 */
	public List<Integer> getFabricatorId() {
		return fabricatorId;
	}

	/**
	 * Setter for {@code CommodityFilter}'s {@code Fabricator}'s id List,
	 * changes this {@code CommodityFilter}'s {@code Fabricator}'s id List
	 * @param fabricatorId this {@code CommodityFilter}'s new {@code Fabricator}'s id List
	 */
	public void setFabricatorId(List<Integer> fabricatorId) {
		this.fabricatorId = fabricatorId;
	}

}
