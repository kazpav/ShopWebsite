package ua.website.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.website.entity.SaleStatus;
import ua.website.entity.User;
import ua.website.entity.UserCommodity;

public interface UserCommodityDao extends JpaRepository<UserCommodity, Integer>{
	
	
	//try to use id if doesn't work
	@Query("SELECT u FROM UserCommodity u LEFT JOIN FETCH u.user LEFT JOIN FETCH u.commodity WHERE u.user.id=?1"
			+ " and u.status=?2")
	List<UserCommodity> findUserPurchases(int id, SaleStatus status);
	
	@Query("SELECT u FROM UserCommodity u LEFT JOIN FETCH u.user LEFT JOIN FETCH u.commodity"
			+ " LEFT JOIN FETCH u.purchaseContact WHERE u.status=?1")
	List<UserCommodity> findPurchases(SaleStatus status);
	
	@Query("SELECT u FROM UserCommodity u WHERE u.user.id=?1 and u.commodity.id=?2 and u.status=?3")
	UserCommodity findUnique(int userId, int commodityId, SaleStatus status);
	
	@Query("SELECT u FROM UserCommodity u LEFT JOIN FETCH u.user LEFT JOIN FETCH u.commodity WHERE u.id=?1")
	UserCommodity findOne(int id);
}
