package ua.website.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class SubcategoryFilter {
	private String search = "";
	
	private List<Integer> categoryId = new ArrayList<Integer>();

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<Integer> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<Integer> categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
