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
 * between Subcategory Objects in application and DB
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
	 * Finds all Subcategories in DataBase
	 * @return List of all Subcategories
	 */
	@Query("SELECT s FROM Subcategory s LEFT JOIN FETCH s.category")
	List<Subcategory> findAll();

	/**
	 * Finds Subcategory with same id as parameter
	 * @param id Subcategory's id you want to find
	 * @return found Subcategory
	 */
	@Query("SELECT s FROM Subcategory s LEFT JOIN FETCH s.category WHERE s.id=?1")
	Subcategory findOne(int id);

	/**
	 * Finds Subcategory with the same name as String parameter
	 * @param name name of Subcategory we are looking for
	 * @return found Subcategory
	 */
	Subcategory findByName(String name);

	/**
	 * Finds all Subcategories representing them in Page perspective
	 * @param pageable
	 * @return pages of Subcategories
	 */
	@Query(value="SELECT s FROM Subcategory s LEFT JOIN FETCH s.category",
			countQuery="SELECT count(s.id)FROM Subcategory s")
	Page<Subcategory> findAll(Pageable pageable);
}
