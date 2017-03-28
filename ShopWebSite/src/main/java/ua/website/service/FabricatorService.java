package ua.website.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.website.dto.filter.SimpleFilter;
import ua.website.entity.Fabricator;

public interface FabricatorService {
	void save(Fabricator fabricator);
	List<Fabricator> findAll();
	Fabricator findOne(int id);
	void delete(int id);
	void update(Fabricator fabricator);
	Fabricator findByName(String name);
	
	Page<Fabricator> findAll(SimpleFilter filter,Pageable pageable);

}
