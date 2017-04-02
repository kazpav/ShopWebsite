package ua.website.serviceImpl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.website.dao.CommodityDao;
import ua.website.dao.CountryDao;
import ua.website.dao.UserDao;
import ua.website.entity.Role;
import ua.website.entity.User;
import ua.website.service.UserService;
@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private CommodityDao commDao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
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

	public User findByName(String name) {
		return userDao.findByName(name);
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String useremail)
			throws UsernameNotFoundException {
		return userDao.findByEmail(useremail);
	}
	
	@PostConstruct
	public void addAdmin(){
		User user = userDao.findByEmail("admin");
		if(user==null){
			user = new User();
			user.setPassword(encoder.encode("admin"));
			user.setEmail("admin");
			user.setName("admin");
			user.setRole(Role.ROLE_ADMIN);
			userDao.save(user);
		}
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
