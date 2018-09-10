package ua.website.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.website.entity.Subcategory;

/**
 * Data Access Object interface provides connection
 * between {@code Subcategory} Objects in application and DB
 * using JpaRepository to make main requests to DataBase,
 *  JpaSpecificationExecutor  to allow execution of Specification
 *  and  queries
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Subcategory
 * @see ua.website.serviceImpl.SubcategoryServiceImpl
 */
public interface SubcategoryDao extends JpaRepository<Subcategory, Integer>,JpaSpecificationExecutor<Subcategory> {

	/**
	 * Finds all {@code Subcategory}'s in DataBase
	 * @return List of all Subcategories
	 */
	@Query("SELECT s FROM Subcategory s LEFT JOIN FETCH s.category")
	List<Subcategory> findAll();

	/**
	 * Finds {@code Subcategory} with same id as parameter
	 * @param id {@code Subcategory}'s id you want to find
	 * @return found {@code Subcategory}
	 */
	@Query("SELECT s FROM Subcategory s LEFT JOIN FETCH s.category WHERE s.id=?1")
	Subcategory findOne(int id);

	/**
	 * Finds {@code Subcategory} with the same name as String parameter
	 * @param name name of {@code Subcategory} we are looking for
	 * @return found {@code Subcategory}
	 */
	Subcategory findByName(String name);

	/**
	 * Finds all {@code Subcategory} representing them in Page perspective
	 * @param pageable
	 * @return pages of {@code Subcategory}
	 */
	@Query(value="SELECT s FROM Subcategory s LEFT JOIN FETCH s.category",
			countQuery="SELECT count(s.id)FROM Subcategory s")
	Page<Subcategory> findAll(Pageable pageable);
}
