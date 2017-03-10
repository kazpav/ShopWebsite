package ua.website.dto.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CommodityFilter {
	private String nameSearch = "";
	private String min = "";
	private String max = "";
	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	private List<Integer> countryId = new ArrayList<>();
	private List<Integer> colorId = new ArrayList<>();
	private List<Integer> subcategoryId = new ArrayList<>();
	private List<Integer> categoryId = new ArrayList<>();
	private List<Integer> fabricatorId = new ArrayList<>();

	
	
	public String getNameSearch() {
		return nameSearch;
	}

	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public List<Integer> getCountryId() {
		return countryId;
	}

	public void setCountryId(List<Integer> countryId) {
		this.countryId = countryId;
	}

	public List<Integer> getColorId() {
		return colorId;
	}

	public void setColorId(List<Integer> colorId) {
		this.colorId = colorId;
	}

	public List<Integer> getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(List<Integer> subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public List<Integer> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<Integer> categoryId) {
		this.categoryId = categoryId;
	}

	public List<Integer> getFabricatorId() {
		return fabricatorId;
	}

	public void setFabricatorId(List<Integer> fabricatorId) {
		this.fabricatorId = fabricatorId;
	}

}
