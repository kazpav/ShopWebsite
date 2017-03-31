package ua.website.service;

import java.util.List;

import ua.website.dto.form.UserCommodityForm;
import ua.website.entity.SaleStatus;
import ua.website.entity.UserCommodity;

public interface UserCommodityService {
	void saveForm(UserCommodityForm form);
	void save(UserCommodity userCommodity);
	List<UserCommodity> findAll();
	UserCommodity findOne(int id);
	void delete(int id);
	void update(UserCommodity userCommodity);
	
	UserCommodityForm findForm(int id);
	
	List<UserCommodity> findUserPurchases(int id, SaleStatus status);
	UserCommodity findUnique(int userId, int commodityId, SaleStatus status);
	
	void confirmPurchase(List<UserCommodity> list);

}
