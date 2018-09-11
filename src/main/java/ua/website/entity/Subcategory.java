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

	/** {@code Subcategory}'s id used as primary key */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** {@code Subcategory}'s name represented in separate column*/
	@Column(name="_name")
	private String name;

	/** {@code Category} related to this {@code Subcategory}*/
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;

	/**
	 *  Default constructor.
	 *  Initializes a newly created {@code Subcategory} with empty fields
	 */
	public Subcategory() {
	}

	/**
	 * Constructor; initializes a newly created {@code Subcategory} with it's fields
	 * @param name {@code Subcategory}'s new name
	 */
	public Subcategory(String name) {
		super();
		this.name = name;
	}

	/**
	 * Getter for {@code Subcategory}'s id
	 * @return {@code Subcategory}'s id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for {@code Subcategory}'s id
	 * Changes {@code Subcategory}'s id
	 * @param id new {@code Subcategory}'s id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for {@code Subcategory}'s name
	 * @return {@code Subcategory}'s name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for {@code Subcategory}'s name
	 * Changes {@code Subcategory}'s name
	 * @param name new {@code Subcategory}'s name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for {@code Subcategory}'s {@code Category}
	 * @return {@code Subcategory}'s {@code Category}
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Setter for {@code Subcategory}'s {@code Category}
	 * Changes {@code Subcategory}'s {@code Category}
	 * @param category new {@code Subcategory}'s {@code Category}
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
