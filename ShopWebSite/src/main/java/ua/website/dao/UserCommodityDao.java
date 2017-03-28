package ua.website.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.website.entity.User;
import ua.website.entity.UserCommodity;

public interface UserCommodityDao extends JpaRepository<UserCommodity, Integer>{
	
	
	//try to use id if doesn't work
	@Query("SELECT u FROM UserCommodity u LEFT JOIN FETCH u.user LEFT JOIN FETCH u.commodity WHERE u.user.id=?1")
	List<UserCommodity> findComByUser(int id);
	
	@Query("SELECT u FROM UserCommodity u WHERE u.user.id=?1 and u.commodity.id=?2")
	UserCommodity findUnique(int userId, int commodityId);
	
	@Query("SELECT u FROM UserCommodity u LEFT JOIN FETCH u.user LEFT JOIN FETCH u.commodity WHERE u.id=?1")
	UserCommodity findOne(int id);
}
