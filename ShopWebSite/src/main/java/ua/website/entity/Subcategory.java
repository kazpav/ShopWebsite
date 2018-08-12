package ua.website.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * POJO class representing Subcategories
 * labeled with persistence annotations
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 */
@Entity
@Table(name="subcategory")
public class Subcategory {

	/** Subcategory's id used as primary key */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** Subcategory's name represented in separate column*/
	@Column(name="_name")
	private String name;

	/** Category related to this Subcategory */
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;

	/**
	 *  Default constructor.
	 *  Initializes a newly created Subcategory with empty fields
	 */
	public Subcategory() {
	}

	/**
	 * Constructor; initializes a newly created Subcategory with it's fields
	 * @param name Subcategory's new name
	 */
	public Subcategory(String name) {
		super();
		this.name = name;
	}

	/**
	 * Getter for Subcategory's id
	 * @return Subcategory's id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for Subcategory's id
	 * Changes Subcategory's id
	 * @param id new Subcategory's id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for Subcategory's name
	 * @return Subcategory's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for Subcategory's name
	 * Changes Subcategory's name
	 * @param name new Subcategory's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for Subcategory's Caregory
	 * @return Subcategory's Caregory
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Setter for Subcategory's Category
	 * Changes Subcategory's Category
	 * @param category new Subcategory's Category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * Realization of toString method
	 * @return String representation of this Object
	 */
	@Override
	public String toString() {
		return "Subcategory [id=" + id + ", name=" + name + "]";
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
		Subcategory other = (Subcategory) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
