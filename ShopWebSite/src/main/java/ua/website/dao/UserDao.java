package ua.website.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import ua.website.entity.User;

/**
 * Data Access Object interface provides connection
 * between {@code User} Objects in application and DB
 * using JpaRepository to make main requests to DataBase,
 *  JpaSpecificationExecutor  to allow execution of Specification
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.User
 * @see ua.website.serviceImpl.UserServiceImpl
 */
public interface UserDao extends JpaRepository<User, Integer> {

	/**
	 * Finds {@code User} by name specified in parameter
	 * @param name {@code User} you want to find
	 * @return found {@code User}
	 */
	User findByName(String name);

	/**
	 * Finds {@code User} by email specified in parameter
	 * @param email Email of {@code User} you want to find
	 * @return found {@code User}
	 */
	User findByEmail(String email);
}
