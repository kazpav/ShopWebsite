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

	/** Category id used as primary key */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** Category name represented in separate column*/
	@Column(name="_name")
	private String name;

	/**
	 *  List of Subcategories that relates to this Category
	 * @see ua.website.entity.Subcategory
	 */
	@OneToMany(mappedBy="category", fetch=FetchType.LAZY)
	private List<Subcategory> subcategories;

	/**
	 * List of Commodities that relates to this Category
	 * @see ua.website.entity.Commodity
	 */
	@OneToMany(mappedBy="category", fetch=FetchType.LAZY)
	private List<Commodity> commodities;

	/**
	 *  Default constructor.
	 *  Initializes a newly created Category with empty fields
	 */
	public Category() {
	}

	/**
	 * Constructor; initializes a newly created Category with it's fields
	 * @param name Category new name
	 */
	public Category(String name) {
		super();
		this.name = name;
	}

	/**
	 * Getter for Category id
	 * @return Category id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for Category id
	 * Changes Category id
	 * @param id new Category id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for Category name
	 * @return Category name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for Category name
	 * Changes Category name
	 * @param name new Category name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for List of Category's Subcategories
	 * @return List of Category's Subcategories
	 */
	public List<Subcategory> getSubcategories() {
		return subcategories;
	}

	/**
	 * Setter for Category's List of Subcategories
	 * Changes List of Subcategories that relates to this Category
	 * @param subcategories List of new Category's Subcategories
	 */
	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

	/**
	 * Getter for List of Category's Commodities
	 * @return List of Category's Commodities
	 */
	public List<Commodity> getCommodities() {
		return commodities;
	}

	/**
	 * Setter for Category's List of Commodities
	 * Changes List of Commodities that relates to this Category
	 * @param commodities List of new Category's Commodities
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
