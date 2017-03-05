package ua.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.website.dao.CountryDao;
import ua.website.entity.Country;
import ua.website.service.CountryService;
@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryDao countryDao;
	
	public void save(Country country) {
		country.getName().toUpperCase();
		countryDao.save(country);
	}

	public List<Country> findAll() {
		return countryDao.findAll();
	}

	public Country findOne(int id) {
		return countryDao.findOne(id);
	}

	public void delete(int id) {
		countryDao.delete(id);
	}

	public void update(Country country) {
		countryDao.save(country);
	}

	public Country findByName(String name) {
		return countryDao.findByName(name);
	}

}
