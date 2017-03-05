package ua.website.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import ua.website.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

	Category findByName(String name);

}
