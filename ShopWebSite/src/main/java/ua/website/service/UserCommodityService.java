package ua.website.service;

import java.util.List;

import ua.website.dto.form.UserCommodityForm;
import ua.website.entity.UserCommodity;

public interface UserCommodityService {
	void saveForm(UserCommodityForm form);
	void save(UserCommodity userCommodity);
	List<UserCommodity> findAll();
	UserCommodity findOne(int id);
	void delete(int id);
	void update(UserCommodity userCommodity);
	
	UserCommodityForm findForm(int id);
	
	List<UserCommodity> findComByUser(int id);
	UserCommodity findUnique(int userId, int commodityId);

}
