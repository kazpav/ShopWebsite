package ua.website.dto.form;

import ua.website.entity.Commodity;
import ua.website.entity.SaleStatus;
import ua.website.entity.User;

/**
 * Data Transfer Object that you need to validate {@code UserCommodity} objects
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.UserCommodity
 * @see ua.website.validator.BasketValidator
 */
public class UserCommodityForm {

	/** id used as primary key */
	private int id;

	/** number of purchased Commodities */
	private String number;

	/**
	 * Enumerated status of sale
	 * @see ua.website.entity.SaleStatus
	 */
	private SaleStatus status;

	/** Related {@code User} */
	private User user;

	/** Related {@code Commodity}*/
	private Commodity commodity;

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
	 * Getter for number
	 * @return this number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Setter for number
	 * @param number new number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Getter for related {@code User}
	 * @return this {@code User}
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Setter for related {@code User}
	 * @param user new {@code User}
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Getter for related {@code Commodity}
	 * @return this {@code Commodity}
	 */
	public Commodity getCommodity() {
		return commodity;
	}

	/**
	 * Setter for related {@code Commodity}
	 * @param commodity new {@code Commodity}
	 */
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
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
		
}
