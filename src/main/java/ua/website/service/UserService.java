package ua.website.service;

import java.util.List;

import ua.website.entity.User;

/**
 * Service interface that works with {@code User} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.User
 * @see ua.website.dao.UserDao
 * @see ua.website.serviceImpl.UserServiceImpl
 */
public interface UserService {

	/**
	 * Saves {@code User} in DataBase
	 * @param user {@code User} you want to save
	 */
	void save(User user);

	/**
	 * Finds all {@code User}'s in DataBase
	 * @return List of found {@code User}'s
	 */
	List<User> findAll();

	/**
	 * Finds {@code User} with same id as parameter
	 * @param id id of {@code User} you want to find
	 * @return found {@code User}
	 */
	User findOne(int id);

	/**
	 * Deletes {@code User} with same id as parameter
	 * @param id id of {@code User} you want to delete
	 */
	void delete(int id);

	/**
	 * Updates {@code User} specified in parameter
	 * @param user {@code User} you want to update
	 */
	void update(User user);

	/**
	 * Finds {@code User} with same name as parameter
	 * @param name name of {@code User} you want to find
	 * @return found {@code User}
	 */
	User findByName(String name);

	/**
	 * Finds {@code User} with same email as parameter
	 * @param email email of {@code User} you want to find
	 * @return found {@code User}
	 */
	User findByEmail(String email);

	/**
	 * Creates new empty unregistered {@code User}
	 * @return new {@codeUser} id
	 */
	int createNewUser();
}
