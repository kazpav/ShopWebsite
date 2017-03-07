package ua.website.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.website.entity.Country;

public interface CountryDao extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country> {

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
