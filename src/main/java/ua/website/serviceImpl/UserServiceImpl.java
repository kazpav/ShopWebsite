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

/**
 * Service that works with {@code User} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.User
 * @see ua.website.dao.UserDao
 * @see ua.website.service.UserService
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService{

	/** Dependency Injection of {@code UserDao} */
	@Autowired
	private UserDao userDao;

	/** Dependency Injection of {@code CountryDao} */
	@Autowired
	private CountryDao countryDao;

	/** Dependency Injection of {@code CommodityDao} */
	@Autowired
	private CommodityDao commDao;

	/** Dependency Injection of {@code BCryptPasswordEncoder} */
	@Autowired
	private BCryptPasswordEncoder encoder;

	/**
	 * Saves {@code User} in DataBase
	 * @param user {@code User} you want to save
	 */
	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_USER);
		userDao.save(user);
	}

	/**
	 * Finds all {@code User}'s in DataBase
	 * @return List of found {@code User}'s
	 */
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	/**
	 * Finds {@code User} with same id as parameter
	 * @param id id of {@code User} you want to find
	 * @return found {@code User}
	 */
	@Override
	public User findOne(int id) {
		return userDao.findOne(id);
	}

	/**
	 * Deletes {@code User} with same id as parameter
	 * @param id id of {@code User} you want to delete
	 */
	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	/**
	 * Updates {@code User} specified in parameter
	 * @param user {@code User} you want to update
	 */
	@Override
	public void update(User user) {
		userDao.save(user);
	}

	/**
	 * Finds {@code User} with same name as parameter
	 * @param name name of {@code User} you want to find
	 * @return found {@code User}
	 */
	@Override
	public User findByName(String name) {
		return userDao.findByName(name);
	}

	/**
	 * Finds {@code User} with same email as parameter
	 * @param email email of {@code User} you want to find
	 * @return found {@code User}
	 */
	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	/**
	 * Finds {@code UserDetails} by email
	 * @param useremail email of {@code User}
	 * @return found {@code UserDetails}
	 * @throws UsernameNotFoundException {@code User} not found in system
	 */
	@Override
	public UserDetails loadUserByUsername(String useremail)
			throws UsernameNotFoundException {
		return userDao.findByEmail(useremail);
	}

	/** Adds admin account, if application runs for the first time */
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

	/**
	 * Creates new empty unregistered {@code User}
	 * @return new {@codeUser} id
	 */
	@Override
	public int createNewUser() {
		User user = new User();
		user.setRole(Role.ROLE_UNREGISTERED);
		return userDao.saveAndFlush(user).getId();
	}

}
