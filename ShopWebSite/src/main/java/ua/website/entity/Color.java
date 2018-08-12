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

	/** Color's id used as primary key */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** Color's name represented in separate column*/
	@Column
	private String name;

	/**
	 * List of Commodities that relates to this Color
	 * @see ua.website.entity.Commodity
	 */
	@OneToMany(mappedBy="color", fetch=FetchType.LAZY)
	private List<Commodity> commodities;

	/**
	 *  Default constructor.
	 *  Initializes a newly created Color with empty fields
	 */
	public Color() {
	}

	/**
	 * Constructor; initializes a newly created Color with it's fields
	 * @param name Color new name
	 */
	public Color(String name) {
		super();
		this.name = name;
	}

	/**
	 * Getter for Color's id
	 * @return Color's id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for Color's id
	 * Changes Color's id
	 * @param id new Color's id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for Color's name
	 * @return Color's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for Color's name
	 * Changes Color's name
	 * @param name new Color's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for List of Color's Commodities
	 * @return List of Color's Commodities
	 */
	public List<Commodity> getCommodities() {
		return commodities;
	}

	/**
	 * Setter for Color's List of Commodities
	 * Changes List of Commodities that relates to this Color
	 * @param commodities List of new Color's Commodities
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
