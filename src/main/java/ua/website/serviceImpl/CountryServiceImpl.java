package ua.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.website.dao.CountryDao;
import ua.website.dto.filter.SimpleFilter;
import ua.website.entity.Country;
import ua.website.service.CountryService;

/**
 * Service that works with {@code Country} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Country
 * @see ua.website.dao.CountryDao
 * @see ua.website.service.CountryService
 */
@Service
public class CountryServiceImpl implements CountryService{

	/** Dependency Injection of {@code CountryDao} */
	@Autowired
	private CountryDao countryDao;

	/**
	 * Saves {@code Country} in DataBase
	 * @param country {@code Country} you want to save
	 */
	@Override
	public void save(Country country) {
		country.getName().toUpperCase();
		countryDao.save(country);
	}

	/**
	 * Finds all {@code Country}'s in DataBase
	 * @return List of found {@code Country}'s
	 */
	@Override
	public List<Country> findAll() {
		return countryDao.findAll();
	}

	/**
	 * Finds {@code Country} with same id as parameter
	 * @param id id of {@code Country} you want to find
	 * @return found {@code Country}
	 */
	@Override
	public Country findOne(int id) {
		return countryDao.findOne(id);
	}

	/**
	 * Deletes {@code Country} with same id as parameter
	 * @param id id of {@code Country} you want to delete
	 */
	@Override
	public void delete(int id) {
		countryDao.delete(id);
	}

	/**
	 * Updates {@code Country} specified in parameter
	 * @param country {@code Country} you want to update
	 */
	@Override
	public void update(Country country) {
		countryDao.save(country);
	}

	/**
	 * Finds {@code Country} with same name as parameter
	 * @param name name of {@code Country} you want to find
	 * @return found {@code Country}
	 */
	@Override
	public Country findByName(String name) {
		return countryDao.findByName(name);
	}

	/**
	 * Finds all {@code Country}'s in page perspective
	 * @param filter used filter
	 * @param pageable pagination information
	 * @return pages of found {@code Country}'s
	 */
	@Override
	public Page<Country> findAll(SimpleFilter filter, Pageable pageable) {
		return countryDao.findAll(findByNameLike(filter),pageable);
	}

	private Specification<Country> findByNameLike(SimpleFilter filter) {
		return (root,query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch().toLowerCase()+"%");
		};
	}

}
