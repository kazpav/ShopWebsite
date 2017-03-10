package ua.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.website.dao.CategoryDao;
import ua.website.dao.SubcategoryDao;
import ua.website.dto.filter.SimpleFilter;
import ua.website.dto.filter.SubcategoryFilter;
import ua.website.entity.Category;
import ua.website.entity.Subcategory;
import ua.website.service.SubcategoryService;
import ua.website.specification.SubcategorySpecification;
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

//	@Override
//	public Page<Subcategory> findAll(SimpleFilter filter, Pageable pageable) {
//		return subcatDao.findAll(findByNameLike(filter),pageable);
//	}

//	private Specification<Subcategory> findByNameLike(SimpleFilter filter) {
//		return (root,query,cb)->{
//			if(filter.getSearch().isEmpty())return null;
//			return cb.like(cb.lower(root.get("name")), filter.getSearch().toLowerCase()+"%");
//		};
//	}

	@Override
	public Page<Subcategory> findAll(Pageable pageable, SubcategoryFilter filter) {
		return subcatDao.findAll(new SubcategorySpecification(filter), pageable);
	}
}
