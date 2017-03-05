package ua.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.website.dao.CategoryDao;
import ua.website.dao.SubcategoryDao;
import ua.website.entity.Category;
import ua.website.entity.Subcategory;
import ua.website.service.SubcategoryService;
@Service
public class SubcategoryServiceImpl implements SubcategoryService{

	@Autowired
	private SubcategoryDao subcatDao;
	@Autowired
	private CategoryDao categDao;
	
	public void save(Subcategory subcategory) {
		subcategory.getName().toUpperCase();
		subcatDao.save(subcategory);
	}

	public List<Subcategory> findAll() {
		return subcatDao.findAll();
	}

	public Subcategory findOne(int id) {
		return subcatDao.findOne(id);
	}

	public void delete(int id) {
		subcatDao.delete(id);
	}

	public void update(Subcategory subcategory) {
		subcatDao.save(subcategory);
	}

	public void addCategoryToSubcategory(int subcatId, int catId) {
		Subcategory subcategory = subcatDao.findOne(subcatId);
		Category category = categDao.findOne(catId);
		subcategory.setCategory(category);
		subcatDao.save(subcategory);
	}

	public Subcategory findByName(String name) {
		return subcatDao.findByName(name);
	}

}
