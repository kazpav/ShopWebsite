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

	/** {@code Commodity}'s id used as primary key */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** {@code Commodity}'s name represented in separate column*/
	@Column(name="_name")
	private String name;

	/** {@code Commodity}'s price represented in separate column*/
	@Column(name="_price")
	private BigDecimal price;

	/** {@code Commodity}'s description represented in separate column */
	@Column(name="_description")
	private String description;

	/** {@code Commodity}'s version of picture represented in seperate column */
	@Column(name="_version")
	private int version;

	/** Quantity of this {@code Commodity} that is available in shop */
	@Column(name="_quantity")
	private int quantity;

	/**
	 *  Country, where this {@code Commodity} was manufactured
	 * @see ua.website.entity.Country
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private Country country;

	/**
	 * Color of this {@code Commodity}
	 * @see ua.website.entity.Color
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private Color color;

	/**
	 * Subcategory of this {@code Commodity}
	 * @see ua.website.entity.Subcategory
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private Subcategory subcategory;

	/**
	 * Category of this {@code Commodity}
	 * @see ua.website.entity.Category
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;

	/**
	 * Fabricator of this {@code Commodity}
	 * @see ua.website.entity.Fabricator
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private Fabricator fabricator;

	/** List of purchased commodities
	 * from {@code UserCommodity} adjacent table
	 * used instead ManyToMany connection
	 * @see ua.website.entity.UserCommodity
	 */
	@OneToMany(mappedBy="commodity", fetch=FetchType.LAZY)
	private List<UserCommodity> userCommodities;

	/**
	 * Default constructor.
	 * Initializes a newly created {@code Commodity} with empty fields
	 */
	public Commodity() {
	}

	/**
	 * Constructor; initializes a newly created {@code Commodity} with it's fields
	 * @param name {@code Commodity}'s name
	 * @param price {@code Commodity}'s price
	 * @param description {@code Commodity}'s description
	 * @param quantity quantity of {@code Commodity}'s
	 */
	public Commodity(String name, BigDecimal price, String description, int quantity) {
	this.name = name;
	this.price = price;
	this.description = description;
	this.quantity = quantity;
	}

	/**
	 * Getter for {@code Commodity}'s id
	 * @return this {@code Commodity}'s id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for {@code Commodity}'s id,
	 * changes this {@code Commodity}'s id
	 * @param id this {@code Commodity}'s new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for {@code Commodity}'s name
	 * @return this {@code Commodity}'s name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for {@code Commodity}'s name,
	 * changes this {@code Commodity}'s name
	 * @param name this {@code Commodity}'s new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for {@code Commodity}'s version of picture
	 * @return this {@code Commodity}'s version of picture
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * Setter for {@code Commodity}'s version of picture,
	 * changes this {@code Commodity}'s version of picture
	 * @param version this {@code Commodity}'s new version of picture
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * Getter for {@code Commodity}'s price
	 * @return this {@code Commodity}'s price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Setter for {@code Commodity}'s price,
	 * changes this {@code Commodity}'s price
	 * @param price this {@code Commodity}'s new price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * Getter for {@code Commodity}'s description
	 * @return this {@code Commodity}'s description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter for {@code Commodity}'s description,
	 * changes this {@code Commodity}'s description
	 * @param description this {@code Commodity}'s new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter for quantity of {@code Commodity}'s
	 * @return quantity of this {@code Commodity}'s
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter for quantity of {@code Commodity}'s,
	 * changes quantity of this {@code Commodity}
	 * @param quantity new quantity of this {@code Commodity}
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Getter for {@code Commodity}'s {@code Country}
	 * @return this {@code Commodity}'s {@code Country}
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Setter for {@code Commodity}'s {@code Country},
	 * changes this {@code Commodity}'s {@code Country}
	 * @param country this {@code Commodity}'s new {@code Country}
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * Getter for {@code Commodity}'s {@code Color}
	 * @return this {@code Commodity}'s {@code Color}
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Setter for {@code Commodity}'s {@code Color},
	 * changes this {@code Commodity}'s {@code Color}
	 * @param color this {@code Commodity}'s new {@code Color}
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Getter for {@code Commodity}'s {@code Subcategory}
	 * @return this {@code Commodity}'s {@code Subcategory}
	 */
	public Subcategory getSubcategory() {
		return subcategory;
	}

	/**
	 * Setter for {@code Commodity}'s {@code Subcategory},
	 * changes this {@code Commodity}'s {@code Subcategory}
	 * @param subcategory this {@code Commodity}'s new {@code Subcategory}
	 */
	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	/**
	 * Getter for {@code Commodity}'s {@code Category}
	 * @return this {@code Commodity}'s {@code Category}
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Setter for {@code Commodity}'s {@code Category},
	 * changes this {@code Commodity}'s {@code Category}
	 * @param category this {@code Commodity}'s new {@code Category}
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * Getter for {@code Commodity}'s {@code Fabricator@code
	 * @return this {@code Commodity}'s {@code Fabricator}
	 */
	public Fabricator getFabricator() {
		return fabricator;
	}

	/**
	 * Setter for {@code Commodity}'s {@code Fabricator},
	 * changes this {@code Commodity}'s {@code Fabricator}
	 * @param fabricator this {@code Commodity}'s new {@code Fabricator}
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
