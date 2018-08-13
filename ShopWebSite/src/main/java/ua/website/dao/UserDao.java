package ua.website.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import ua.website.entity.User;

/**
 * Data Access Object interface provides connection
 * between User Objects in application and DB
 * using JpaRepository to make main requests to DataBase,
 *  JpaSpecificationExecutor  to allow execution of Specification
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.User
 * @see ua.website.serviceImpl.UserServiceImpl
 */
public interface UserDao extends JpaRepository<User, Integer> {

	/**
	 * Finds User by name specified in parameter
	 * @param name User you want to find
	 * @return found User
	 */
	User findByName(String name);

	/**
	 * Finds User by email specified in parameter
	 * @param email Email of User you want to find
	 * @return found User
	 */
	User findByEmail(String email);
}
