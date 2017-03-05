package ua.website.service;

import java.util.List;

import ua.website.entity.Category;

public interface CategoryService {
	void save(Category category);
	List<Category> findAll();
	Category findOne(int id);
	void delete(int id);
	void update(Category category);
	Category findByName(String name);
	
}
