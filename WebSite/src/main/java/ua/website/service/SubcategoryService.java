package ua.website.service;

import java.util.List;

import ua.website.entity.Subcategory;

public interface SubcategoryService {
	void save(Subcategory subcategory);
	List<Subcategory> findAll();
	Subcategory findOne(int id);
	void delete(int id);
	void update(Subcategory subcategory);
	void addCategoryToSubcategory(int subcatId, int catId);
	Subcategory findByName(String name);
}
