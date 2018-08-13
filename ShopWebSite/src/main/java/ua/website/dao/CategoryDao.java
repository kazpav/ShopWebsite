package ua.website.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.website.entity.Category;

/**
 * Data Access Object interface provides connection
 * between Category Objects in application and DB
 * using JpaRepository to make main requests to DataBase
 * and JpaSpecificationExecutor  to allow execution of Specification
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Category
 * @see ua.website.serviceImpl.CategoryServiceImpl
 */
public interface CategoryDao extends JpaRepository<Category, Integer>,JpaSpecificationExecutor<Category> {

	Category findByName(String name);

}
