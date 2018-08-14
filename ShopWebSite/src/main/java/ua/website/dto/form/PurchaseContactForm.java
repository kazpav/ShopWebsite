package ua.website.dto.form;


/**
 * Data Transfer Object that you need to validate {@code PurchaseContact} objects
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.PurchaseContact
 * @see ua.website.validator.PurchaseContactValidator
 */
public class PurchaseContactForm {

	/** {@code PurchaseContactForm}'s id */
	private int id;

	/** {@code PurchaseContactForm}'s fullName */
	private String fullName;

	/** {@code PurchaseContactForm}'s contactNumber */
	private String contactNumber;

	/** {@code PurchaseContactForm}'s address*/
	private String address;

	/** {@code PurchaseContactForm}'s date */
	private String date;


	/**
	 * Getter for {@code PurchaseContactForm} id
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
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * Setter for contactNumber
	 * Changes contactNumber
	 * @param contactNumber new contactNumber
	 */
	public void setContactNumber(String contactNumber) {
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
	public String getDate() {
		return date;
	}

	/**
	 * Setter for purchase date
	 * Changes purchase date
	 * @param date new purchase date
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
