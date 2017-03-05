package ua.website.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.website.entity.Commodity;

public interface CommodityDao extends JpaRepository<Commodity, Integer> {
	
	@Query("SELECT c FROM Commodity c WHERE c.category.id = ?1")
	List<Commodity> findByCategoryId(int id);
	
	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category")
	List<Commodity> findAll();



	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.color LEFT JOIN FETCH c.country"
			+ " LEFT JOIN FETCH c.fabricator LEFT JOIN FETCH c.subcategory LEFT JOIN FETCH c.category WHERE c.id=?1")
	Commodity findOne(int id);
//	public void save(Commodity commodity);
//
//	public void delete(int id);
//
//	public Commodity findOne(int id);
//
//	public List<Commodity> findAll();
//	
//	void update(Commodity commodity);

	Commodity findByName(String name);
}
