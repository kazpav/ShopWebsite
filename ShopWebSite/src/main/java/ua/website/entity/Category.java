package ua.website.entity;

import javax.persistence.*;
import java.util.List;

/**
 * POJO class representing Categories of Commodities
 * labeled with persistence annotations
 * @author Pavlo Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 */
@Entity
@Table(name="category")
public class Category {

	/** {@code Category}'s id used as primary key */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** {@code Category}'s name represented in separate column*/
	@Column(name="_name")
	private String name;

	/**
	 *  List of {@code Subcategory}'s that relates to this {@code Category}
	 * @see ua.website.entity.Subcategory
	 */
	@OneToMany(mappedBy="category", fetch=FetchType.LAZY)
	private List<Subcategory> subcategories;

	/**
	 * List of {@code Commodity}'s that relates to this {@code Category}
	 * @see ua.website.entity.Commodity
	 */
	@OneToMany(mappedBy="category", fetch=FetchType.LAZY)
	private List<Commodity> commodities;

	/**
	 *  Default constructor.
	 *  Initializes a newly created {@code Category} with empty fields
	 */
	public Category() {
	}

	/**
	 * Constructor; initializes a newly created {@code Category} with it's fields
	 * @param name {@code Category}'s new name
	 */
	public Category(String name) {
		super();
		this.name = name;
	}

	/**
	 * Getter for {@code Category}'s id
	 * @return {@code Category}'s id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for {@code Category}'s id
	 * Changes {@code Category}'s id
	 * @param id new {@code Category}'s id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for {@code Category}'s name
	 * @return {@code Category}'s name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for {@code Category}'s name
	 * Changes {@code Category}'s name
	 * @param name new {@code Category}'s name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for List of {@code Category}'s Subcategories
	 * @return List of {@code Category}'s Subcategories
	 */
	public List<Subcategory> getSubcategories() {
		return subcategories;
	}

	/**
	 * Setter for {@code Category}'s List of {@code Subcategory}'s
	 * Changes List of {@code Subcategory}'s that relates to this {@code Category}
	 * @param subcategories List of new {@code Category}'s {@code Subcategory}'s
	 */
	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

	/**
	 * Getter for List of {@code Category}'s {@code Commodity}
	 * @return List of {@code Category}'s {@code Commodity}'s
	 */
	public List<Commodity> getCommodities() {
		return commodities;
	}

	/**
	 * Setter for {@code Category}'s List of {@code Commodity}'s
	 * Changes List of {@code Commodity}'s that relates to this {@code Category}
	 * @param commodities List of new {@code Category}'s {@code Commodity}'s
	 */
	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

	/**
	 * Realization of toString method
	 * @return String representation of this Object
	 */
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
