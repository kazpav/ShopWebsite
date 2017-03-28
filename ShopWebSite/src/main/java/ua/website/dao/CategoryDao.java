package ua.website.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.website.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>,JpaSpecificationExecutor<Category> {

	Category findByName(String name);

}
