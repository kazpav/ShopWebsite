package ua.website.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.website.entity.Commodity;

public interface CommodityDao extends JpaRepository<Commodity, Integer>, JpaSpecificationExecutor<Commodity> {
	
	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category"
			+" WHERE c.category.id = ?1")
	List<Commodity> findByCategoryId(int id);
	
	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category")
	List<Commodity> findAll();



	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category WHERE c.id=?1")
	Commodity findOne(int id);

	Commodity findByName(String name);
	
	@Query(value="SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category",
			countQuery="SELECT count(c.id) FROM Commodity c")
	Page<Commodity> findAll(Pageable pageable);
	
}
