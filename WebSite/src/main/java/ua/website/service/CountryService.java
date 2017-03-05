package ua.website.service;

import java.util.List;

import ua.website.entity.Country;

public interface CountryService {
	void save(Country country);
	List<Country> findAll();
	Country findOne(int id);
	void delete(int id);
	void update(Country country);
	Country findByName(String name);
}
