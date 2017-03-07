package ua.website.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.website.dto.filter.SimpleFilter;
import ua.website.entity.Color;

public interface ColorService {
	void save(Color	color);
	List<Color> findAll();
	Color findOne(int id);
	void delete(int id);
	void update(Color color);
	Color findByName(String name);
	
	Page<Color> findAll(SimpleFilter filter,Pageable pageable);

	
}
