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
 * POJO class representing Countries of manufacturing of Commodities
 * labeled with persistence annotations
 * @author Pavlo Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 */
@Entity
@Table(name="country")
public class Country {

	/** Country's id used as primary key */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** Country's name represented in separate column*/
	@Column(name="_name")
	private String name;

	/**
	 * List of Commodities that relates to this Country
	 * @see ua.website.entity.Commodity
	 */
	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private List<Commodity> commodities;

	/**
	 *  Default constructor.
	 *  Initializes a newly created Country with empty fields
	 */
	public Country() {
	}

	/**
	 * Constructor; initializes a newly created Country with it's fields
	 * @param name Color new name
	 */
	public Country(String name) {
		super();
		this.name = name;
	}

	/**
	 * Getter for Country's id
	 * @return Country's id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for Country's id
	 * Changes Country's id
	 * @param id new Country's id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for Country's name
	 * @return Country's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for Country's name
	 * Changes Country's name
	 * @param name new Country's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for List of Country's Commodities
	 * @return List of Country's Commodities
	 */
	public List<Commodity> getCommodities() {
		return commodities;
	}

	/**
	 * Setter for Country's List of Commodities
	 * Changes List of Commodities that relates to this Country
	 * @param commodities List of new Country's Commodities
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
		return "Country [id=" + id + ", name=" + name + "]";
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
		Country other = (Country) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
