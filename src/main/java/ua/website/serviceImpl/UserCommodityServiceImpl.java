package ua.website.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.website.dao.UserCommodityDao;
import ua.website.dto.form.UserCommodityForm;
import ua.website.entity.PurchaseContact;
import ua.website.entity.SaleStatus;
import ua.website.entity.UserCommodity;
import ua.website.service.UserCommodityService;

/**
 * Service that works with {@code UserCommodity} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.UserCommodity
 * @see ua.website.dao.UserCommodityDao
 * @see ua.website.service.UserCommodityService
 */
@Service
public class UserCommodityServiceImpl implements UserCommodityService{

	/** Dependency Injection of {@code UserCommodityDao} */
	@Autowired
	private UserCommodityDao userCommodityDao;

	/**
	 * Saves {@code UserCommodity} converted from {@code UserCommodityForm}
	 * @param form {@code UserCommodityForm} you want to convert
	 */
	@Override
	public void saveForm(UserCommodityForm form) {
		UserCommodity entity = new UserCommodity();
//		entity.setId(form.getId());
		entity.setStatus(form.getStatus());
		entity.setNumber(new Integer(form.getNumber()));
		entity.setUser(form.getUser());
		entity.setCommodity(form.getCommodity());
		userCommodityDao.save(entity);
	}

	/**
	 * Saves {@code UserCommodity} in DataBase
	 * @param userCommodity {@code UserCommodity} you want to save
	 */
	@Override
	public void save(UserCommodity userCommodity) {
		userCommodityDao.save(userCommodity);
	}

	/**
	 * Finds all {@code UserCommodity}'s in DataBase
	 * @return List of found {@code UserCommodity}'s
	 */
	@Override
	public List<UserCommodity> findAll() {
		return userCommodityDao.findAll();
	}

	/**
	 * Finds {@code UserCommodity} with same id as parameter
	 * @param id id of {@code UserCommodity} you want to find
	 * @return found {@code UserCommodity}
	 */
	@Override
	public UserCommodity findOne(int id) {
		return userCommodityDao.findOne(id);
	}

	/**
	 * Deletes {@code UserCommodity} with same id as parameter
	 * @param id id of {@code UserCommodity} you want to delete
	 */
	@Override
	public void delete(int id) {
		userCommodityDao.delete(id);
	}

	/**
	 * Updates {@code UserCommodity} specified in parameter
	 * @param userCommodity {@code UserCommodity} you want to update
	 */
	@Override
	public void update(UserCommodity userCommodity) {
		userCommodityDao.save(userCommodity);
	}

	/**
	 * Finds {@code UserCommodity} with specified id and status
	 * @param id id of {@code UserCommodity} you want to find
	 * @param status status of {@code UserCommodity} you want to find
	 * @return found {@code UserCommodity}
	 */
	@Override
	public List<UserCommodity> findUserPurchases(int id, SaleStatus status) {
		return userCommodityDao.findUserPurchases(id, status);
	}

	/**
	 * Finds {@code UserCommodity} by id and converts it to {@code UserCommodityForm}
	 * @param id {@code UserCommodity} you want to find
	 * @return converted {@code UserCommodityForm}
	 */
	@Override
	public UserCommodityForm findForm(int id) {
		UserCommodity entity = findOne(id);
		UserCommodityForm form = new UserCommodityForm();
		form.setId(entity.getId());
		form.setCommodity(entity.getCommodity());
		form.setUser(entity.getUser());
		form.setNumber(String.valueOf(entity.getNumber()));
		form.setStatus(entity.getStatus());
		return form;
	}

	/**
	 * Finds {@code UserCommodity} with specified {@code User} id,
	 * {@code Commodity id} and status
	 * @param userId id of {@code User} related to this {@code UserCommodity}
	 * @param commodityId id of {@code Commodity} related to this {@code UserCommodity}
	 * @param status status of {@code UserCommodity}
	 * @return found {@code UserCommodity}
	 */
	@Override
	public UserCommodity findUnique(int userId, int commodityId, SaleStatus status) {
		return userCommodityDao.findUnique(userId, commodityId, status);
	}

	/**
	 * Confirms purchase from User, setting appropriate status to this sale
	 * @param list list of {@code UserCommodity} representing chosen {@code Commodity}'s by this {@code User}
	 * @param purchaseContact {@code PurchaseContact} object with contact information about this purchase
	 */
	@Override
	public void confirmPurchase(List<UserCommodity> list, PurchaseContact purchaseContact) {
		for (UserCommodity userCommodity : list) {
			userCommodity.setStatus(SaleStatus.STATUS_CONFIRMED);
			userCommodity.setPurchaseContact(purchaseContact);
			userCommodityDao.save(userCommodity);
		}
		
	}

	/**
	 * Finds {@code UserCommodity}'s with specified status
	 * @param status status {@code UserCommodity} you want to find
	 * @return list of found {@code UserCommodity}
	 */
	@Override
	public List<UserCommodity> findPurchases(SaleStatus status) {
		return userCommodityDao.findPurchases(status);
	}

	/**
	 * Finds quantity of {@code Commodity} in {@code User} basket
	 * @param id {@code User} id
	 * @param status status of purchase
	 * @return quantity of purchases
	 */
	@Override
	public int findQuantityOfUserPurchasesInBaset(int id, SaleStatus status) {
		List<UserCommodity> list = userCommodityDao.findUserPurchases(id, status);
		return list.size();
	}

	/**
	 * Finds quantity of all confirmed purchases by all Users
	 * @param status status of purchases
	 * @return quantity of found purchases
	 */
	@Override
	public int findQuantityOfConfirmedPurchases(SaleStatus status) {
		List<UserCommodity> list = userCommodityDao.findPurchases(status);
		return list.size();
	}

	/**
	 * Counts summary price for purchases mady by {@code User}
	 * @param id id of this {@code User}
	 * @param status status of purchases
	 * @return Counted price
	 */
	@Override
	public BigDecimal findSummCostForUser(int id, SaleStatus status) {
		BigDecimal summ= new BigDecimal(0.0);
		List<UserCommodity> list = userCommodityDao.findUserPurchases(id, status);
		for (UserCommodity userCommodity : list) {
			summ = summ.add(userCommodity.getCommodity().getPrice().multiply(new BigDecimal(userCommodity.getNumber())));
		}
		return summ;
	}

}
