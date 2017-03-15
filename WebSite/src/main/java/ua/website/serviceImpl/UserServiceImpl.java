package ua.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.website.dao.CommodityDao;
import ua.website.dao.CountryDao;
import ua.website.dao.UserDao;
import ua.website.entity.Commodity;
import ua.website.entity.Country;
import ua.website.entity.Role;
import ua.website.entity.User;
import ua.website.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private CommodityDao commDao;
	
	public void save(User user) {
		user.setRole(Role.ROLE_USER);
		userDao.save(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public void update(User user) {
		userDao.save(user);
	}
//
//	public void AddCountryToUser(int idUser, int idCountry) {
//		User user = userDao.findOne(idUser);
//		Country country = countryDao.findOne(idCountry);
//		
//		userDao.save(user);
//	}

	

	public User findByName(String name) {
		return userDao.findByName(name);
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
//	public void addCommodityToUser(int UserId, int CommodId){
//		User user = userDao.findOne(UserId);
//		Commodity commodity = commDao.findOne(CommodId);
//
//		user.getCommodities().add(commodity);
//		userDao.save(user);
//	}
//
//	public User fetchUserWithCommod(String name) {
//		return userDao.fetchUserWithCommod(name);
//	}

}
