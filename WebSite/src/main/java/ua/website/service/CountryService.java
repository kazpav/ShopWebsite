package ua.website.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.website.dto.filter.SimpleFilter;
import ua.website.entity.Country;

public interface CountryService {
	void save(Country country);
	List<Country> findAll();
	Country findOne(int id);
	void delete(int id);
	void update(Country country);
	Country findByName(String name);
	
	Page<Country> findAll(SimpleFilter filter,Pageable pageable);
}
