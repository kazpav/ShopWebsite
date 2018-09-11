package ua.website.dto.form;


import org.springframework.web.multipart.MultipartFile;

import ua.website.entity.Category;
import ua.website.entity.Color;
import ua.website.entity.Country;
import ua.website.entity.Fabricator;
import ua.website.entity.Subcategory;

/**
 * Data Transfer Object that you need to validate {@code Commodity} objects
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 * @see ua.website.validator.CommodityValidator
 */
public class CommodityForm {

	/** {@code CommodityForm}'s id */
	private int id;

	/** {@code CommodityForm}'s name */
	private String name;

	/** {@code CommodityForm}'s price */
	private String price;

	/** Quantity of {@code CommodityForm}'s */
	private String quantity;

	/** {@code CommodityForm}'s description */
	private String description;

	/** Version of {@code CommodityForm}'s picture */
	private int version;

	/** {@code CommodityForm}'s picture */
	private MultipartFile file;

	/** {@code Country} related to this {@code CommodityForm} */
	private Country country;

	/** {@code Color} related to this {@code CommodityForm} */
	private Color color;

	/** {@code Subcategory} related to this {@code CommodityForm} */
	private Subcategory subcategory;

	/** {@code Category} related to this {@code CommodityForm} */
	private Category category;

	/** {@code Fabricator} related to this {@code CommodityForm} */
	private Fabricator fabricator;

	/**
	 * Getter for {@code CommodityForm}'s id
	 * @return this {@code CommodityForm}'s id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for {@code CommodityForm}'s id,
	 * changes this {@code CommodityForm}'s id
	 * @param id this {@code CommodityForm}'s new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for {@code CommodityForm}'s name
	 * @return this {@code CommodityForm}'s name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for {@code CommodityForm}'s name,
	 * changes this {@code CommodityForm}'s name
	 * @param name this {@code CommodityForm}'s new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for {@code CommodityForm}'s price
	 * @return this {@code CommodityForm}'s price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * Setter for {@code CommodityForm}'s price,
	 * changes this {@code CommodityForm}'s price
	 * @param price this {@code CommodityForm}'s new price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * Getter for {@code CommodityForm}'s description
	 * @return this {@code CommodityForm}'s description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter for {@code CommodityForm}'s description,
	 * changes this {@code CommodityForm}'s description
	 * @param description this {@code CommodityForm}'s new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter for {@code CommodityForm}'s {@code Country}
	 * @return this {@code CommodityForm}'s {@code Country}
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Setter for {@code CommodityForm}'s {@code Country},
	 * changes this {@code CommodityForm}'s {@code Country}
	 * @param country this {@code CommodityForm}'s new {@code Country}
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * Getter for {@code CommodityForm}'s {@code Color}
	 * @return this {@code CommodityForm}'s {@code Color}
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Setter for {@code CommodityForm}'s {@code Color},
	 * changes this {@code CommodityForm}'s {@code Color}
	 * @param color this {@code CommodityForm}'s new {@code Color}
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Getter for {@code CommodityForm}'s {@code Subcategory}
	 * @return this {@code CommodityForm}'s {@code Subcategory}
	 */
	public Subcategory getSubcategory() {
		return subcategory;
	}

	/**
	 * Setter for {@code CommodityForm}'s {@code Subcategory},
	 * changes this {@code CommodityForm}'s {@code Subcategory}
	 * @param subcategory this {@code CommodityForm}'s new {@code Subcategory}
	 */
	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	/**
	 * Getter for {@code CommodityForm}'s {@code Category}
	 * @return this {@code CommodityForm}'s {@code Category}
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Setter for {@code CommodityForm}'s {@code Category},
	 * changes this {@code CommodityForm}'s {@code Category}
	 * @param category this {@code CommodityForm}'s new {@code Category}
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * Getter for {@code CommodityForm}'s {@code Fabricator}
	 * @return this {@code CommodityForm}'s {@code Fabricator}
	 */
	public Fabricator getFabricator() {
		return fabricator;
	}

	/**
	 * Setter for {@code CommodityForm}'s {@code Fabricator},
	 * changes this {@code CommodityForm}'s {@code Fabricator}
	 * @param fabricator this {@code CommodityForm}'s new {@code Fabricator}
	 */
	public void setFabricator(Fabricator fabricator) {
		this.fabricator = fabricator;
	}

	/**
	 * Getter for {@code CommodityForm}'s version of picture
	 * @return this {@code CommodityForm}'s version of picture
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * Setter for {@code CommodityForm}'s version of picture,
	 * changes this {@code CommodityForm}'s version of picture
	 * @param version this {@code CommodityForm}'s new version of picture
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * Getter for {@code CommodityForm}'s picture
	 * @return this {@code CommodityForm}'s picture
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * Setter for {@code CommodityForm}'s picture,
	 * changes this {@code CommodityForm}'s picture
	 * @param file this {@code CommodityForm}'s of picture
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 * Getter for quantity of {@code CommodityForm}
	 * @return quantity of this {@code CommodityForm}
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * Setter for quantity of {@code CommodityForm},
	 * changes quantity of this {@code CommodityForm}
	 * @param quantity new quantity of this {@code CommodityForm}
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
