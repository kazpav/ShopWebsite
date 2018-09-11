package ua.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.website.dao.CategoryDao;
import ua.website.dao.SubcategoryDao;
import ua.website.dto.filter.SubcategoryFilter;
import ua.website.entity.Category;
import ua.website.entity.Subcategory;
import ua.website.service.SubcategoryService;
import ua.website.specification.SubcategorySpecification;

/**
 * Service that works with {@code Subcategory} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Subcategory
 * @see ua.website.dao.SubcategoryDao
 * @see ua.website.service.SubcategoryService
 */
@Service
public class SubcategoryServiceImpl implements SubcategoryService{

	/** Dependency Injection of {@code SubcategoryDao} */
	@Autowired
	private SubcategoryDao subcatDao;

	/** Dependency Injection of {@code CategoryDao} */
	@Autowired
	private CategoryDao categDao;

	/**
	 * Saves {@code Subcategory} in DataBase
	 * @param subcategory {@code Subcategory} you want to save
	 */
	@Override
	public void save(Subcategory subcategory) {
		subcategory.getName().toUpperCase();
		subcatDao.save(subcategory);
	}

	/**
	 * Finds all {@code Subcategory}'s in DataBase
	 * @return List of found {@code Subcategory}'s
	 */
	@Override
	public List<Subcategory> findAll() {
		return subcatDao.findAll();
	}

	/**
	 * Finds {@code Subcategory} with same id as parameter
	 * @param id id of {@code Subcategory} you want to find
	 * @return found {@code Subcategory}
	 */
	@Override
	public Subcategory findOne(int id) {
		return subcatDao.findOne(id);
	}

	/**
	 * Deletes {@code Subcategory} with same id as parameter
	 * @param id id of {@code Subcategory} you want to delete
	 */
	@Override
	public void delete(int id) {
		subcatDao.delete(id);
	}

	/**
	 * Updates {@code Subcategory} specified in parameter
	 * @param subcategory {@code Subcategory} you want to update
	 */
	@Override
	public void update(Subcategory subcategory) {
		subcatDao.save(subcategory);
	}

	/**
	 * Adds {@code Category} to {@code Subcategory}
	 * @param subcatId id of {@code Subcategory} you want to connect
	 * @param catId id of {@code Category} you want to connect
	 */
	@Override
	public void addCategoryToSubcategory(int subcatId, int catId) {
		Subcategory subcategory = subcatDao.findOne(subcatId);
		Category category = categDao.findOne(catId);
		subcategory.setCategory(category);
		subcatDao.save(subcategory);
	}

	/**
	 * Finds {@code Subcategory} with same name as parameter
	 * @param name name of {@code Subcategory} you want to find
	 * @return found {@code Subcategory}
	 */
	@Override
	public Subcategory findByName(String name) {
		return subcatDao.findByName(name);
	}


	/**
	 * Finds all {@code Subcategory}'s in page perspective
	 * @param filter used filter
	 * @param pageable pagination information
	 * @return pages of found {@code Subcategory}'s
	 */
	@Override
	public Page<Subcategory> findAll(Pageable pageable, SubcategoryFilter filter) {
		return subcatDao.findAll(new SubcategorySpecification(filter), pageable);
	}
}
