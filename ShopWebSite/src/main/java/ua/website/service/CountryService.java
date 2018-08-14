package ua.website.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.website.dto.filter.SimpleFilter;
import ua.website.entity.Country;

/**
 * Service interface that works with {@code Country} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Country
 * @see ua.website.dao.CountryDao
 * @see ua.website.serviceImpl.CountryServiceImpl
 */
public interface CountryService {

	/**
	 * Saves {@code Country} in DataBase
	 * @param country {@code Country} you want to save
	 */
	void save(Country country);

	/**
	 * Finds all {@code Country}'s in DataBase
	 * @return List of found {@code Country}'s
	 */
	List<Country> findAll();

	/**
	 * Finds {@code Country} with same id as parameter
	 * @param id id of {@code Country} you want to find
	 * @return found {@code Country}
	 */
	Country findOne(int id);

	/**
	 * Deletes {@code Country} with same id as parameter
	 * @param id id of {@code Country} you want to delete
	 */
	void delete(int id);

	/**
	 * Updates {@code Country} specified in parameter
	 * @param country {@code Country} you want to update
	 */
	void update(Country country);

	/**
	 * Finds {@code Country} with same name as parameter
	 * @param name name of {@code Country} you want to find
	 * @return found {@code Country}
	 */
	Country findByName(String name);

	/**
	 * Finds all {@code Country}'s in page perspective
	 * @param filter used filter
	 * @param pageable pagination information
	 * @return pages of found {@code Country}'s
	 */
	Page<Country> findAll(SimpleFilter filter,Pageable pageable);
}
