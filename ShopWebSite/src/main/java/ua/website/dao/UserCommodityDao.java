package ua.website.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.website.entity.SaleStatus;
import ua.website.entity.User;
import ua.website.entity.UserCommodity;

/**
 * Data Access Object interface provides connection
 * between {@code UserCommodity} Objects in application and DB
 * using JpaRepository to make main requests to DataBase,
 *  JpaSpecificationExecutor  to allow execution of Specification
 *  and  queries
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.UserCommodity
 * @see ua.website.serviceImpl.UserCommodityServiceImpl
 */
public interface UserCommodityDao extends JpaRepository<UserCommodity, Integer>{


	/**
	 * Finds List of purchases made by {@code User} with specified id
	 * @param id id of {@code User} you want to find
	 * @param status Status of sale
	 * @return List of found {@code UserCommodity}'s
	 */
	@Query("SELECT u FROM UserCommodity u LEFT JOIN FETCH u.user LEFT JOIN FETCH u.commodity WHERE u.user.id=?1"
			+ " and u.status=?2")
	List<UserCommodity> findUserPurchases(int id, SaleStatus status);

	/**
	 * Finds all {@code UserCommodity}'s with specified status
	 * @param status sale status you want to find
	 * @return List of found {@code UserCommodity}'s
	 */
	@Query("SELECT u FROM UserCommodity u LEFT JOIN FETCH u.user LEFT JOIN FETCH u.commodity"
			+ " LEFT JOIN FETCH u.purchaseContact WHERE u.status=?1")
	List<UserCommodity> findPurchases(SaleStatus status);

	/**
	 * Finds purchase of specified {@code Commodity} by specified {@code User} with specified status
	 * @param userId {@code User} id you want to find
	 * @param commodityId {@code Commodity} id you want to find
	 * @param status {@code SaleStatus} you want to find
	 * @return
	 */
	@Query("SELECT u FROM UserCommodity u WHERE u.user.id=?1 and u.commodity.id=?2 and u.status=?3")
	UserCommodity findUnique(int userId, int commodityId, SaleStatus status);

	/**
	 * Finds sale with same id as parameter
	 * @param id id of sale you want to find
	 * @return found {@code UserCommodity}
	 */
	@Query("SELECT u FROM UserCommodity u LEFT JOIN FETCH u.user LEFT JOIN FETCH u.commodity WHERE u.id=?1")
	UserCommodity findOne(int id);
}
