package ua.website.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.website.dto.filter.SimpleFilter;
import ua.website.entity.Fabricator;

/**
 * Service interface that works with {@code Fabricator} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Fabricator
 * @see ua.website.dao.FabricatorDao
 * @see ua.website.serviceImpl.FabricatorServiceImpl
 */
public interface FabricatorService {

	/**
	 * Saves {@code Fabricator} in DataBase
	 * @param fabricator {@code Fabricator} you want to save
	 */
	void save(Fabricator fabricator);

	/**
	 * Finds all {@code Fabricator}'s in DataBase
	 * @return List of found {@code Fabricator}'s
	 */
	List<Fabricator> findAll();

	/**
	 * Finds {@code Fabricator} with same id as parameter
	 * @param id id of {@code Fabricator} you want to find
	 * @return found {@code Fabricator}
	 */
	Fabricator findOne(int id);

	/**
	 * Deletes {@code Fabricator} with same id as parameter
	 * @param id id of {@code Fabricator} you want to delete
	 */
	void delete(int id);

	/**
	 * Updates {@code Fabricator} specified in parameter
	 * @param fabricator {@code Fabricator} you want to update
	 */
	void update(Fabricator fabricator);

	/**
	 * Finds {@code Fabricator} with same name as parameter
	 * @param name name of {@code Fabricator} you want to find
	 * @return found {@code Fabricator}
	 */
	Fabricator findByName(String name);

	/**
	 * Finds all {@code Fabricator}'s in page perspective
	 * @param filter used filter
	 * @param pageable pagination information
	 * @return pages of found {@code Fabricator}'s
	 */
	Page<Fabricator> findAll(SimpleFilter filter,Pageable pageable);

}
