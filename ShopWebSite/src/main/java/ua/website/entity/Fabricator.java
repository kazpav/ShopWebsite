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
 * POJO class representing Fabricators of Commodities
 * labeled with persistence annotations
 * @author Pavlo Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 */
@Entity
@Table(name="fabricator")
public class Fabricator {

	/** Fabricator's id used as primary key */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** Fabricator's name represented in separate column*/
	@Column(name="_name")
	private String name;

	/**
	 * List of Commodities that relates to this Fabricator
	 * @see ua.website.entity.Commodity
	 */
	@OneToMany(mappedBy="fabricator", fetch=FetchType.LAZY)
	private List<Commodity> commodities;

	/**
	 *  Default constructor.
	 *  Initializes a newly created Fabricator with empty fields
	 */
	public Fabricator() {

	}

	/**
	 * Constructor; initializes a newly created Fabricator with it's fields
	 * @param name Color new name
	 */
	public Fabricator(String name) {
		super();
		this.name = name;
	}

	/**
	 * Getter for Fabricator's id
	 * @return Fabricator's id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for Fabricator's id
	 * Changes Fabricator's id
	 * @param id new Fabricator's id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for Fabricator's name
	 * @return Fabricator's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for Fabricator's name
	 * Changes Fabricator's name
	 * @param name new Fabricator's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for List of Fabricator's Commodities
	 * @return List of Fabricator's Commodities
	 */
	public List<Commodity> getCommodities() {
		return commodities;
	}

	/**
	 * Setter for Fabricator's List of Commodities
	 * Changes List of Commodities that relates to this Fabricator
	 * @param commodities List of new Fabricator's Commodities
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
		return "Fabricator [id=" + id + ", name=" + name + "]";
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
		Fabricator other = (Fabricator) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
