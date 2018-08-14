package ua.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.website.dao.CategoryDao;
import ua.website.dto.filter.SimpleFilter;
import ua.website.entity.Category;
import ua.website.service.CategoryService;

/**
 * Service that works with {@code Category} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Category
 * @see ua.website.dao.CategoryDao
 * @see ua.website.service.CategoryService
 */
@Service
public class CategoryServiceImpl implements CategoryService{

	/** Dependency Injection of {@code CategoryDao} */
	@Autowired
	private CategoryDao categoryDao;

	/**
	 * Saves {@code Category} in DataBase
	 * @param category {@code Category} you want to save
	 */
	@Override
	public void save(Category category) {
		category.getName().toUpperCase();
		categoryDao.save(category);
	}

	/**
	 * Finds all {@code Category}'s in DataBase
	 * @return List of found {@code Category}'s
	 */
	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	/**
	 * Finds {@code Category} with same id as parameter
	 * @param id id of {@code Category} you want to find
	 * @return found {@code Category}
	 */
	@Override
	public Category findOne(int id) {
		return categoryDao.findOne(id);
	}

	/**
	 * Deletes {@code Category} with same id as parameter
	 * @param id id of {@code Category} you want to delete
	 */
	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	/**
	 * Updates {@code Category} specified in parameter
	 * @param category {@code Category} you want to update
	 */
	@Override
	public void update(Category category) {
		categoryDao.save(category);
		
	}

	/**
	 * Finds {@code Category} with same name as parameter
	 * @param name name of {@code Category} you want to find
	 * @return found {@code Category}
	 */
	@Override
	public Category findByName(String name) {
		return categoryDao.findByName(name);
	}

	/**
	 * Finds all {@code Category}'s in page perspective
	 * @param filter used filter
	 * @param pageable pagination information
	 * @return pages of found {@code Category}'s
	 */
	@Override
	public Page<Category> findAll(SimpleFilter filter, Pageable pageable) {
		return categoryDao.findAll(findByNameLike(filter),pageable);
	}

	/**
	 * Finds all {@code Category}'s with similar name as parameter
 	 * @param filter
	 * @return
	 */
	private Specification<Category> findByNameLike(SimpleFilter filter) {
		return (root,query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch().toLowerCase()+"%");
		};
	}

}
