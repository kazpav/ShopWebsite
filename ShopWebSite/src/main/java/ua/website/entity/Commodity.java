package ua.website.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * POJO class representing Commodities
 * labeled with persistence annotations
 * @author Pavlo Kazarin
 * @version 1.0
 */
@Entity
@Table(name="commodity")
public class Commodity {

	/** Commodity's id used as primary key */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** Commodity's name represented in separate column*/
	@Column(name="_name")
	private String name;

	/** Commodity's price represented in separate column*/
	@Column(name="_price")
	private BigDecimal price;

	/** Commodity's description represented in separate column */
	@Column(name="_description")
	private String description;

	/** Commodity's version of picture represented in seperate column */
	@Column(name="_version")
	private int version;

	/** Quantity of this Commodity that is available in shop */
	@Column(name="_quantity")
	private int quantity;

	/**
	 *  Country, where this commodity was manufactured
	 * @see ua.website.entity.Country
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private Country country;

	/**
	 * Color of this Commodity
	 * @see ua.website.entity.Color
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private Color color;

	/**
	 * Subcategory of this Commodity
	 * @see ua.website.entity.Subcategory
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private Subcategory subcategory;

	/**
	 * Category of this Commodity
	 * @see ua.website.entity.Category
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;

	/**
	 * Fabricator of this Commodity
	 * @see ua.website.entity.Fabricator
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private Fabricator fabricator;

	/** List of purchased commodities
	 * from UserCommodity adjacent table
	 * used instead ManyToMany connection
	 * @see ua.website.entity.UserCommodity
	 */
	@OneToMany(mappedBy="commodity", fetch=FetchType.LAZY)
	private List<UserCommodity> userCommodities;

	/**
	 * Default constructor.
	 * Initializes a newly created Commodity with empty fields
	 */
	public Commodity() {
	}

	/**
	 * Constructor; initializes a newly created User with it's fields
	 * @param name Commodity's name
	 * @param price Commodity's price
	 * @param description Commodity's description
	 * @param quantity quantity of Commodities
	 */
	public Commodity(String name, BigDecimal price, String description, int quantity) {
	this.name = name;
	this.price = price;
	this.description = description;
	this.quantity = quantity;
	}

	/**
	 * Getter for Commodity's id
	 * @return this Commodity's id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for Commodity's id,
	 * changes this Commodity's id
	 * @param id this Commodity's new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for Commodity's name
	 * @return this Commodity's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for Commodity's name,
	 * changes this Commodity's name
	 * @param name this Commodity's new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for Commodity's version of picture
	 * @return this Commodity's version of picture
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * Setter for Commodity's version of picture,
	 * changes this Commodity's version of picture
	 * @param version this Commodity's new version of picture
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * Getter for Commodity's price
	 * @return this Commodity's price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Setter for Commodity's price,
	 * changes this Commodity's price
	 * @param price this Commodity's new price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * Getter for Commodity's description
	 * @return this Commodity's description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter for Commodity's description,
	 * changes this Commodity's description
	 * @param description this Commodity's new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter for quantity of Commodities
	 * @return quantity of this Commodities
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter for quantity of Commodities,
	 * changes quantity of this Commodity
	 * @param quantity new quantity of this Commodity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Getter for Commodity's Country
	 * @return this Commodity's Country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Setter for Commodity's Country,
	 * changes this Commodity's Country
	 * @param country this Commodity's new Country
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * Getter for Commodity's Color
	 * @return this Commodity's Color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Setter for Commodity's Color,
	 * changes this Commodity's Color
	 * @param color this Commodity's new Color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Getter for Commodity's Subcategory
	 * @return this Commodity's Subcategory
	 */
	public Subcategory getSubcategory() {
		return subcategory;
	}

	/**
	 * Setter for Commodity's Subcategory,
	 * changes this Commodity's Subcategory
	 * @param subcategory this Commodity's new Subcategory
	 */
	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	/**
	 * Getter for Commodity's Category
	 * @return this Commodity's Category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Setter for Commodity's Category,
	 * changes this Commodity's Category
	 * @param category this Commodity's new Category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * Getter for Commodity's Fabricator
	 * @return this Commodity's Fabricator
	 */
	public Fabricator getFabricator() {
		return fabricator;
	}

	/**
	 * Setter for Commodity's Fabricator,
	 * changes this Commodity's Fabricator
	 * @param fabricator this Commodity's new Fabricator
	 */
	public void setFabricator(Fabricator fabricator) {
		this.fabricator = fabricator;
	}

	/**
	 * realization of toString method
	 * @return String representation of this Object
	 */
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", price=" + price
				+ ", description=" + description + "]";
	}

	/**
	 * Generates and returns hash code
	 * @return hash code of this object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Compares two objects
	 * @param obj Object to compare
	 * @return if this object is the same as the object argument
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commodity other = (Commodity) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
