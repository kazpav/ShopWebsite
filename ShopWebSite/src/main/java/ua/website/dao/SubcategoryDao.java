package ua.website.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Query(value="SELECT s FROM Subcategory s LEFT JOIN FETCH s.category",
			countQuery="SELECT count(s.id)FROM Subcategory s")
	Page<Subcategory> findAll(Pageable pageable);
}
