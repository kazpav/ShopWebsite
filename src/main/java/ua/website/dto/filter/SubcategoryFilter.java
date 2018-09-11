package ua.website.dto.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Transfer Object that you need for filtering {@code Subcategory}'s on web page
 * Describes object that comes from filtering form for it's converting in future
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Subcategory
 * @see ua.website.specification.SubcategorySpecification
 * @see ua.website.controller.admin.SubcategoryController
 * @see ua.website.service.SubcategoryService
 */
public class SubcategoryFilter {

	/** {@code Subcategory}'s  name client is looking for*/
	private String search = "";

	/** {@code Category}'s related to {@code Subcategory}'s client is looking for*/
	private List<Integer> categoryId = new ArrayList<Integer>();

	/**
	 * Getter for {@code SubcategoryFilter}'s search
	 * @return this {@code SubcategoryFilter}'s search
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * Setter for {@code SubcategoryFilter}'s search,
	 * changes this {@code SubcategoryFilter}'s search
	 * @param search this {@code SubcategoryFilter}'s new search
	 */
	public void setSearch(String search) {
		this.search = search;
	}

	/**
	 * Getter for {@code SubcategoryFilter}'s {@code Category}'s id List
	 * @return this {@code SubcategoryFilter}'s {@code Category}'s id List
	 */
	public List<Integer> getCategoryId() {
		return categoryId;
	}

	/**
	 * Setter for {@code SubcategoryFilter}'s {@code Category}'s id List,
	 * changes this {@code SubcategoryFilter}'s {@code Category}'s id List
	 * @param categoryId this {@code SubcategoryFilter}'s new {@code Category}'s id List
	 */
	public void setCategoryId(List<Integer> categoryId) {
		this.categoryId = categoryId;
	}

}
