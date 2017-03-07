package ua.website.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.website.entity.Subcategory;

public interface SubcategoryDao extends JpaRepository<Subcategory, Integer>,JpaSpecificationExecutor<Subcategory> {
	
	
	@Query("SELECT s FROM Subcategory s LEFT JOIN FETCH s.category")
	List<Subcategory> findAll();
	@Query("SELECT s FROM Subcategory s LEFT JOIN FETCH s.category WHERE s.id=?1")
	Subcategory findOne(int id);
	Subcategory findByName(String name);
	
//	@Query("SELECT s  FROM Subcategory s WHERE s.category.id = ?1")
	
//	public void save(Subcategory subcategory);
//
//	public void delete(int id);
//
//	public Subcategory findOne(int id);
//
//	public List<Subcategory> findAll();
//	
//	void update(Subcategory subcategory);
}
