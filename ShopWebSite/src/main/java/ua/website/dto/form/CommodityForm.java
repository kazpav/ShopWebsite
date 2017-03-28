package ua.website.dto.form;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.springframework.web.multipart.MultipartFile;

import ua.website.entity.Category;
import ua.website.entity.Color;
import ua.website.entity.Country;
import ua.website.entity.Fabricator;
import ua.website.entity.Subcategory;

public class CommodityForm {
	private int id;

	private String name;

	private String price;
	
	private String quantity;

	private String description;
	
	private int version;
	
	private MultipartFile file;

	private Country country;

	private Color color;

	private Subcategory subcategory;

	private Category category;

	private Fabricator fabricator;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Fabricator getFabricator() {
		return fabricator;
	}

	public void setFabricator(Fabricator fabricator) {
		this.fabricator = fabricator;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
