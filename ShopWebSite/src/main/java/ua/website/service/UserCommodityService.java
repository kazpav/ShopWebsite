package ua.website.service;

import java.math.BigDecimal;
import java.util.List;

import ua.website.dto.form.UserCommodityForm;
import ua.website.entity.PurchaseContact;
import ua.website.entity.SaleStatus;
import ua.website.entity.UserCommodity;

/**
 * Service interface that works with {@code UserCommodity} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.UserCommodity
 * @see ua.website.dao.UserCommodityDao
 * @see ua.website.serviceImpl.UserCommodityServiceImpl
 */
public interface UserCommodityService {

	/**
	 * Saves {@code UserCommodity} converted from {@code UserCommodityForm}
	 * @param form {@code UserCommodityForm} you want to convert
	 */
	void saveForm(UserCommodityForm form);

	/**
	 * Saves {@code UserCommodity} in DataBase
	 * @param userCommodity {@code UserCommodity} you want to save
	 */
	void save(UserCommodity userCommodity);

	/**
	 * Finds all {@code UserCommodity}'s in DataBase
	 * @return List of found {@code UserCommodity}'s
	 */
	List<UserCommodity> findAll();

	/**
	 * Finds {@code UserCommodity} with same id as parameter
	 * @param id id of {@code UserCommodity} you want to find
	 * @return found {@code UserCommodity}
	 */
	UserCommodity findOne(int id);

	/**
	 * Deletes {@code UserCommodity} with same id as parameter
	 * @param id id of {@code UserCommodity} you want to delete
	 */
	void delete(int id);

	/**
	 * Updates {@code UserCommodity} specified in parameter
	 * @param userCommodity {@code UserCommodity} you want to update
	 */
	void update(UserCommodity userCommodity);

	/**
	 * Finds {@code UserCommodity} by id and converts it to {@code UserCommodityForm}
	 * @param id {@code UserCommodity} you want to find
	 * @return converted {@code UserCommodityForm}
	 */
	UserCommodityForm findForm(int id);

	/**
	 * Finds {@code UserCommodity} with specified id and status
	 * @param id id of {@code UserCommodity} you want to find
	 * @param status status of {@code UserCommodity} you want to find
	 * @return found {@code UserCommodity}
	 */
	List<UserCommodity> findUserPurchases(int id, SaleStatus status);

	/**
	 * Finds {@code UserCommodity} with specified {@code User} id,
	 * {@code Commodity id} and status
	 * @param userId id of {@code User} related to this {@code UserCommodity}
	 * @param commodityId id of {@code Commodity} related to this {@code UserCommodity}
	 * @param status status of {@code UserCommodity}
	 * @return found {@code UserCommodity}
	 */
	UserCommodity findUnique(int userId, int commodityId, SaleStatus status);

	/**
	 * Confirms purchase from User, setting appropriate status to this sale
	 * @param list list of {@code UserCommodity} representing chosen {@code Commodity}'s by this {@code User}
	 * @param purchaseContact {@code PurchaseContact} object with contact information about this purchase
	 */
	void confirmPurchase(List<UserCommodity> list, PurchaseContact purchaseContact);

	/**
	 * Finds {@code UserCommodity}'s with specified status
	 * @param status status {@code UserCommodity} you want to find
	 * @return list of found {@code UserCommodity}
	 */
	List<UserCommodity> findPurchases(SaleStatus status);

	/**
	 * Finds quantity of {@code Commodity} in {@code User} basket
	 * @param id {@code User} id
	 * @param status status of purchase
	 * @return quantity of purchases
	 */
	int findQuantityOfUserPurchasesInBaset(int id,SaleStatus status);

	/**
	 * Finds quantity of all confirmed purchases by all Users
	 * @param status status of purchases
	 * @return quantity of found purchases
	 */
	int findQuantityOfConfirmedPurchases(SaleStatus status);


	/**
	 * Counts summary price for purchases mady by {@code User}
	 * @param id id of this {@code User}
	 * @param status status of purchases
	 * @return Counted price
	 */
	BigDecimal findSummCostForUser(int id, SaleStatus status);

}
