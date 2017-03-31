package ua.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.website.dao.UserCommodityDao;
import ua.website.dto.form.UserCommodityForm;
import ua.website.entity.PurchaseContact;
import ua.website.entity.SaleStatus;
import ua.website.entity.UserCommodity;
import ua.website.service.UserCommodityService;

@Service
public class UserCommodityServiceImpl implements UserCommodityService{
	
	@Autowired
	private UserCommodityDao userCommodityDao;
	
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

	@Override
	public List<UserCommodity> findAll() {
		return userCommodityDao.findAll();
	}

	@Override
	public UserCommodity findOne(int id) {
		return userCommodityDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		userCommodityDao.delete(id);
	}

	@Override
	public void update(UserCommodity userCommodity) {
		userCommodityDao.save(userCommodity);
	}

	@Override
	public List<UserCommodity> findUserPurchases(int id, SaleStatus status) {
		return userCommodityDao.findUserPurchases(id, status);
	}

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

	@Override
	public UserCommodity findUnique(int userId, int commodityId, SaleStatus status) {
		return userCommodityDao.findUnique(userId, commodityId, status);
	}

	@Override
	public void save(UserCommodity userCommodity) {
		userCommodityDao.save(userCommodity);
	}

	@Override
	public void confirmPurchase(List<UserCommodity> list, PurchaseContact purchaseContact) {
		for (UserCommodity userCommodity : list) {
			userCommodity.setStatus(SaleStatus.STATUS_CONFIRMED);
			userCommodity.setPurchaseContact(purchaseContact);
			userCommodityDao.save(userCommodity);
		}
		
	}

	@Override
	public List<UserCommodity> findPurchases(SaleStatus status) {
		// TODO Auto-generated method stub
		return userCommodityDao.findPurchases(status);
	}

	
	
}
