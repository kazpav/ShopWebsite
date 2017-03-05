package ua.website.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import ua.website.entity.Country;

public interface CountryDao extends JpaRepository<Country, Integer> {

	Country findByName(String name);
//	public void save(Country country);
//
//	public void delete(int id);
//
//	public Country findOne(int id);
//
//	public List<Country> findAll();
//	
//	void update(Country country);
}
