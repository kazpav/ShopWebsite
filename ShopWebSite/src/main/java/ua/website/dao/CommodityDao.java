package ua.website.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.website.entity.Commodity;

/**
 * Data Access Object interface provides connection
 * between {@code Commodity} Objects in application and DB
 * using JpaRepository to make main requests to DataBase,
 *  JpaSpecificationExecutor  to allow execution of Specification
 *  and  queries
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 * @see ua.website.serviceImpl.CommodityServiceImpl
 */
public interface CommodityDao extends JpaRepository<Commodity, Integer>, JpaSpecificationExecutor<Commodity> {

	/**
	 * Finds {@code Commodity}'s that are related to {@code Category} specified in param
	 * @param id id of {@code Category}
	 * @return List of {@code Commodity}'s related to some {@code Category}
	 */
	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category"
			+" WHERE c.category.id = ?1")
	List<Commodity> findByCategoryId(int id);

	/**
	 * Finds all {@code Commodity}'s in DataBase
	 * @return list of all {@code Commodity}'s
	 */
	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category")
	List<Commodity> findAll();

	/**
	 * Finds {@code Commodity} with same id as parameter
	 * @param id {@code Commodity}'s id you want to find
	 * @return {@code Commodity} Object
	 */
	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category WHERE c.id=?1")
	Commodity findOne(int id);

	/**
	 * Finds {@code Commodity} with same name as param String
	 * @param name Name of {@code Commodity} we are looking for
	 * @return found {@code Commodity}
	 */
	Commodity findByName(String name);

	/**
	 * Finds all {@code Commodity}'s representing them in Page perspective
	 * @param pageable
	 * @return Pages of {@code Commodity}
	 */
	@Query(value="SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category",
			countQuery="SELECT count(c.id) FROM Commodity c")
	Page<Commodity> findAll(Pageable pageable);
	
}
