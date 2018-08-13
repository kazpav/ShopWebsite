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
 * between Commodity Objects in application and DB
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
	 * Finds Commodities that are related to Category specified in param
	 * @param id id of Category
	 * @return List of Commodities related to some Category
	 */
	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category"
			+" WHERE c.category.id = ?1")
	List<Commodity> findByCategoryId(int id);

	/**
	 * Finds all Commodities in DataBase
	 * @return list of all Commodities
	 */
	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category")
	List<Commodity> findAll();

	/**
	 * Finds Commodity with same id as parameter
	 * @param id Commodity's id you want to find
	 * @return Commodity Object
	 */
	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category WHERE c.id=?1")
	Commodity findOne(int id);

	/**
	 * Finds Commodity with same name as param String
	 * @param name Name of Commodity we are looking for
	 * @return found Commodity
	 */
	Commodity findByName(String name);

	/**
	 * Finds all Commodities representing them in Page perspective
	 * @param pageable
	 * @return Pages of Commodities
	 */
	@Query(value="SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category",
			countQuery="SELECT count(c.id) FROM Commodity c")
	Page<Commodity> findAll(Pageable pageable);
	
}
