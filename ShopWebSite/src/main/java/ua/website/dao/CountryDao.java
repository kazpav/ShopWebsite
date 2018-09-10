package ua.website.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.website.entity.Country;

/**
 * Data Access Object interface provides connection
 * between {@code Country} Objects in application and DB
 * using JpaRepository to make main requests to DataBase
 * and JpaSpecificationExecutor  to allow execution of Specification
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Color
 * @see ua.website.serviceImpl.ColorServiceImpl
 */
public interface CountryDao extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country> {

	/**
	 * Finds {@code Country} by it's name
	 * @param name name of {@code Country} you want to find
	 * @return found {@code Country}
	 */
	Country findByName(String name);

}
