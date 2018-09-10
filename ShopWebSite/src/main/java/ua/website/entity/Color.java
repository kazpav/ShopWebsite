package ua.website.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * POJO class representing Colors of Commodities
 * labeled with persistence annotations
 * @author Pavlo Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 */
@Entity
@Table(name="color")
public class Color {

	/** {@code Color}'s id used as primary key */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** {@code Color}'s name represented in separate column*/
	@Column
	private String name;

	/**
	 * List of {@code Commodity}'s that relates to this Color
	 * @see ua.website.entity.Commodity
	 */
	@OneToMany(mappedBy="color", fetch=FetchType.LAZY)
	private List<Commodity> commodities;

	/**
	 *  Default constructor.
	 *  Initializes a newly created {@code Color} with empty fields
	 */
	public Color() {
	}

	/**
	 * Constructor; initializes a newly created {@code Color} with it's fields
	 * @param name Color new name
	 */
	public Color(String name) {
		super();
		this.name = name;
	}

	/**
	 * Getter for {@code Color}'s id
	 * @return {@code Color}'s id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for {@code Color}'s id
	 * Changes {@code Color}'s id
	 * @param id new {@code Color}'s id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for {@code Color}'s name
	 * @return {@code Color}'s name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for {@code Color}'s name
	 * Changes {@code Color}'s name
	 * @param name new {@code Color}'s name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for List of {@code Color}'s {@code Commodity}'s
	 * @return List of {@code Color}'s {@code Commodity}'s
	 */
	public List<Commodity> getCommodities() {
		return commodities;
	}

	/**
	 * Setter for {@code Color}'s List of {@code Commodity}'s
	 * Changes List of {@code Commodity}'s that relates to this {@code Color}
	 * @param commodities List of new {@code Color}'s {@code Commodity}'s
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
		return "Color [id=" + id + ", name=" + name + "]";
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
		Color other = (Color) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
