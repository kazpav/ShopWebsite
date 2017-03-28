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
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	public void save(Category category) {
		category.getName().toUpperCase();
		categoryDao.save(category);
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public Category findOne(int id) {
		return categoryDao.findOne(id);
	}

	public void delete(int id) {
		categoryDao.delete(id);
	}

	public void update(Category category) {
		categoryDao.save(category);
		
	}

	public Category findByName(String name) {
		return categoryDao.findByName(name);
	}

	@Override
	public Page<Category> findAll(SimpleFilter filter, Pageable pageable) {
		return categoryDao.findAll(findByNameLike(filter),pageable);
	}

	private Specification<Category> findByNameLike(SimpleFilter filter) {
		return (root,query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch().toLowerCase()+"%");
		};
	}

}
