package ua.website.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.website.dto.filter.SimpleFilter;
import ua.website.dto.filter.SubcategoryFilter;
import ua.website.entity.Category;
import ua.website.entity.Subcategory;

public interface SubcategoryService {
	void save(Subcategory subcategory);
	List<Subcategory> findAll();
	Subcategory findOne(int id);
	void delete(int id);
	void update(Subcategory subcategory);
	void addCategoryToSubcategory(int subcatId, int catId);
	Subcategory findByName(String name);
	
	Page<Subcategory> findAll(Pageable pageable,SubcategoryFilter filter);

}
