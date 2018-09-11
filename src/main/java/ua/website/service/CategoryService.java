package ua.website.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.website.dto.filter.SimpleFilter;
import ua.website.entity.Category;

/**
 * Service interface that works with {@code Category} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Category
 * @see ua.website.dao.CategoryDao
 * @see ua.website.serviceImpl.CategoryServiceImpl
 */
public interface CategoryService {

	/**
	 * Saves {@code Category} in DataBase
	 * @param category {@code Category} you want to save
	 */
	void save(Category category);

	/**
	 * Finds all {@code Category}'s in DataBase
	 * @return List of found {@code Category}'s
	 */
	List<Category> findAll();

	/**
	 * Finds {@code Category} with same id as parameter
	 * @param id id of {@code Category} you want to find
	 * @return found {@code Category}
	 */
	Category findOne(int id);

	/**
	 * Deletes {@code Category} with same id as parameter
	 * @param id id of {@code Category} you want to delete
	 */
	void delete(int id);

	/**
	 * Updates {@code Category} specified in parameter
	 * @param category {@code Category} you want to update
	 */
	void update(Category category);

	/**
	 * Finds {@code Category} with same name as parameter
	 * @param name name of {@code Category} you want to find
	 * @return found {@code Category}
	 */
	Category findByName(String name);

	/**
	 * Finds all {@code Category}'s in page perspective
	 * @param filter used filter
	 * @param pageable pagination information
	 * @return pages of found {@code Category}'s
	 */
	Page<Category> findAll(SimpleFilter filter,Pageable pageable);
	
}
