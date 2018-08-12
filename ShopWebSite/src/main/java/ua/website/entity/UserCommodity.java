package ua.website.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Adjacent table connecting Users and Commodities
 * realising many to many connection
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.User
 * @see ua.website.entity.Commodity
 */
@Entity
@Table(name="userCommodity")
public class UserCommodity {

	/** id used as primary key */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** number of purchased Commodities */
	@Column(name="_number")
	private int number;

	/**
	 * Enumerated status of sale
	 * @see ua.website.entity.SaleStatus
	 */
	@Enumerated
	@Column(name="_status")
	private SaleStatus status;

	/** Users in this table */
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	/** Commodities in this table */
	@ManyToOne(fetch=FetchType.LAZY)
	private Commodity commodity;

	/** Contact information related to this purchase */
	@ManyToOne(fetch=FetchType.LAZY)
	private PurchaseContact purchaseContact;

	/** Default constructor */
	public UserCommodity() {
	}

	/** Constructor */
	public UserCommodity(int number, SaleStatus status, User user, Commodity commodity,
			PurchaseContact purchaseContact) {
		this.number = number;
		this.status = status;
		this.user = user;
		this.commodity = commodity;
		this.purchaseContact = purchaseContact;
	}

	/**
	 * Getter for id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for id
	 * @param id new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for User
	 * @return this user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Setter for User
	 * @param user new User
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Getter for Commodity
	 * @return this Commodity
	 */
	public Commodity getCommodity() {
		return commodity;
	}

	/**
	 * Setter for Commodity
	 * @param commodity new Commodity
	 */
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	/**
	 * Getter for number
	 * @return this number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Setter for number
	 * @param number new number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Getter for status
	 * @return this status
	 */
	public SaleStatus getStatus() {
		return status;
	}

	/**
	 * Setter for status
	 * @param status new status
	 */
	public void setStatus(SaleStatus status) {
		this.status = status;
	}

	/**
	 * Setter for purchaseContact
	 * @return purchaseContact
	 */
	public PurchaseContact getPurchaseContact() {
		return purchaseContact;
	}

	/**
	 * Setter for purchaseContact
	 * @param purchaseContact new purchaseContact
	 */
	public void setPurchaseContact(PurchaseContact purchaseContact) {
		this.purchaseContact = purchaseContact;
	}

}
