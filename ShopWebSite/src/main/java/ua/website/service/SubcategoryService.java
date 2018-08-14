package ua.website.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.website.dto.filter.SubcategoryFilter;
import ua.website.entity.Subcategory;

/**
 * Service interface that works with {@code Subcategory} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Subcategory
 * @see ua.website.dao.SubcategoryDao
 * @see ua.website.serviceImpl.SubcategoryServiceImpl
 */
public interface SubcategoryService {

	/**
	 * Saves {@code Subcategory} in DataBase
	 * @param subcategory {@code Subcategory} you want to save
	 */
	void save(Subcategory subcategory);

	/**
	 * Finds all {@code Subcategory}'s in DataBase
	 * @return List of found {@code Subcategory}'s
	 */
	List<Subcategory> findAll();

	/**
	 * Finds {@code Subcategory} with same id as parameter
	 * @param id id of {@code Subcategory} you want to find
	 * @return found {@code Subcategory}
	 */
	Subcategory findOne(int id);

	/**
	 * Deletes {@code Subcategory} with same id as parameter
	 * @param id id of {@code Subcategory} you want to delete
	 */
	void delete(int id);

	/**
	 * Updates {@code Subcategory} specified in parameter
	 * @param subcategory {@code Subcategory} you want to update
	 */
	void update(Subcategory subcategory);

	/**
	 * Adds {@code Category} to {@code Subcategory}
	 * @param subcatId id of {@code Subcategory} you want to connect
	 * @param catId id of {@code Category} you want to connect
	 */
	void addCategoryToSubcategory(int subcatId, int catId);

	/**
	 * Finds {@code Subcategory} with same name as parameter
	 * @param name name of {@code Subcategory} you want to find
	 * @return found {@code Subcategory}
	 */
	Subcategory findByName(String name);

	/**
	 * Finds all {@code Subcategory}'s in page perspective
	 * @param filter used filter
	 * @param pageable pagination information
	 * @return pages of found {@code Subcategory}'s
	 */
	Page<Subcategory> findAll(Pageable pageable,SubcategoryFilter filter);

}
