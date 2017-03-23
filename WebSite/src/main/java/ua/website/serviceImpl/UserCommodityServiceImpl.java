package ua.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.website.dao.UserCommodityDao;
import ua.website.entity.UserCommodity;
import ua.website.service.UserCommodityService;

@Service
public class UserCommodityServiceImpl implements UserCommodityService{
	
	@Autowired
	private UserCommodityDao userCommodityDao;
	
	@Override
	public void save(UserCommodity userCommodity) {
		userCommodityDao.save(userCommodity);
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
	public List<UserCommodity> findComByUser(int id) {
		return userCommodityDao.findComByUser(id);
	}

}
