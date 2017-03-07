package ua.website.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.website.dto.filter.SimpleFilter;
import ua.website.entity.Category;

public interface CategoryService {
	void save(Category category);
	List<Category> findAll();
	Category findOne(int id);
	void delete(int id);
	void update(Category category);
	Category findByName(String name);
	
	Page<Category> findAll(SimpleFilter filter,Pageable pageable);
	
}
