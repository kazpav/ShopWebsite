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

	/** PurchaseContact's id used as primary key */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** Customer's name for Contact */
	@Column(name="_fullName")
	private String fullName;

	/** Customer's contact number */
	@Column(name="_contactNumber")
	private int contactNumber;

	/** Customer's address for delivering */
	@Column(name="_address")
	private String address;

	/** Date of making purchase */
	@Column(name="_saleDate")
	private Date date;
	
	/** List of Commodities that were purchased by User */
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
	 * Getter for  id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for id
	 * Changes id
	 * @param id new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for name
	 * @return name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Setter for name
	 * Changes name
	 * @param fullName new name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Getter for contactNumber
	 * @return contactNumber
	 */
	public int getContactNumber() {
		return contactNumber;
	}

	/**
	 * Setter for contactNumber
	 * Changes contactNumber
	 * @param contactNumber new contactNumber
	 */
	public void setContactNumber(int  contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * Getter for address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter for address
	 * Changes address
	 * @param address new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Getter for purchase date
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Setter for purchase date
	 * Changes purchase date
	 * @param date new purchase date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
