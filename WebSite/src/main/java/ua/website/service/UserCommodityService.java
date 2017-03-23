package ua.website.service;

import java.util.List;

import ua.website.entity.UserCommodity;

public interface UserCommodityService {
	void save(UserCommodity userCommodity);
	List<UserCommodity> findAll();
	UserCommodity findOne(int id);
	void delete(int id);
	void update(UserCommodity userCommodity);
	
	List<UserCommodity> findComByUser(int id);

}
