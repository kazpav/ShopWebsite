package ua.website.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.website.entity.Color;

public interface ColorDao extends JpaRepository<Color, Integer>,JpaSpecificationExecutor<Color> {

	Color findByName(String name);
//	public void save(Color color);
//
//	public void delete(int id);
//
//	public Color findOne(int id);
//
//	public List<Color> findAll();
//	
//	void update(Color color);
}
