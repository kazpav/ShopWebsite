package ua.website.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * POJO class representing form with User's contact information
 * for making purchase in shop
 * labeled with persistence annotations
 * @author Pavlo Kazarin
 * @version 1.0
 * @see ua.website.entity.UserCommodity
 */
@Entity
@Table(name="purchaseContact")
public class PurchaseContact{

	/** {@code PurchaseContact}'s id used as primary key */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** Customer's name for {@code PurchaseContact}*/
	@Column(name="_fullName")
	private String fullName;

	/** Customer's contact number for {@code PurchaseContact}*/
	@Column(name="_contactNumber")
	private int contactNumber;

	/** Customer's address for delivering for {@code PurchaseContact}*/
	@Column(name="_address")
	private String address;

	/** Date of making purchase in {@code PurchaseContact}*/
	@Column(name="_saleDate")
	private Date date;
	
	/** List of {@code Commodity}'s that were purchased by {@code User}*/
	@OneToMany(mappedBy="purchaseContact",fetch=FetchType.LAZY)
	private List<UserCommodity> userCommodities;

	/**
	 *  Default constructor.
	 *  Initializes a newly created Object with empty fields
	 */
	public PurchaseContact() {
	}

	/**
	 * Constructor; initializes a newly created Object with it's fields
	 * @param fullName Customer's contact name
	 * @param contactNumber Customer's contact number
	 * @param address Customer's address
	 * @param date Date of purchase
	 */
	public PurchaseContact(String fullName, int contactNumber, String address,
			Date date) {
		this.fullName = fullName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.date = date;
	}

	/**
	 * Getter for {@code PurchaseContact} id
	 * @return {@code PurchaseContact}'s id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for {@code PurchaseContact}'s id
	 * Changes {@code PurchaseContact}'s id
	 * @param id {@code PurchaseContact}'s new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for {@code PurchaseContact}'s name
	 * @return {@code PurchaseContact}'s name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Setter for {@code PurchaseContact}'s name
	 * Changes {@code PurchaseContact}'s name
	 * @param fullName {@code PurchaseContact}'s new name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Getter for {@code PurchaseContact}'s contactNumber
	 * @return {@code PurchaseContact}'s contactNumber
	 */
	public int getContactNumber() {
		return contactNumber;
	}

	/**
	 * Setter for {@code PurchaseContact}'s contactNumber
	 * Changes {@code PurchaseContact}'s contactNumber
	 * @param contactNumber new {@code PurchaseContact}'s contactNumber
	 */
	public void setContactNumber(int  contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * Getter for {@code PurchaseContact}'s address
	 * @return {@code PurchaseContact}'s address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter for {@code PurchaseContact}'s address
	 * Changes {@code PurchaseContact}'s address
	 * @param address {@code PurchaseContact}'s new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Getter for {@code PurchaseContact}'s purchase date
	 * @return {@code PurchaseContact}'s date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Setter for {@code PurchaseContact}'s purchase date
	 * Changes {@code PurchaseContact}'s purchase date
	 * @param date {@code PurchaseContact}'s new purchase date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
