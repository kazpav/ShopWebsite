package ua.website.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.website.dto.filter.CommodityFilter;
import ua.website.dto.form.CommodityForm;
import ua.website.entity.Commodity;

/**
 * Service interface that works with {@code Commodity} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 * @see ua.website.dao.CommodityDao
 * @see ua.website.serviceImpl.CommodityServiceImpl
 */
public interface CommodityService {

	/**
	 * Saves {@code Commodity} converted from {@code CommodityForm}
	 * @param form {@code CommodityForm} you want to convert
	 */
	void saveForm(CommodityForm form);

	/**
	 * Saves {@code Commodity} in DataBase
	 * @param commodity {@code Commodity} you want to save
	 */
	void save(Commodity commodity);

	/**
	 * Finds all {@code Commodity}'s in DataBase
	 * @return List of found {@code Commodity}'s
	 */
	List<Commodity> findAll();

	/**
	 * Finds {@code Commodity} with same id as parameter
	 * @param id id of {@code Commodity} you want to find
	 * @return found {@code Commodity}
	 */
	Commodity findOne(int id);

	/**
	 * Deletes {@code Commodity} with same id as parameter
	 * @param id id of {@code Commodity} you want to delete
	 */
	void delete(int id);

	/**
	 * Updates {@code Commodity} specified in parameter
	 * @param commodity {@code Commodity} you want to update
	 */
	void update(Commodity commodity);

	/**
	 * Finds {@code Commodity} by id and converts it to {@code CommodityForm}
	 * @param id {@code Commodity} you want to find
	 * @return converted {@code CommodityForm}
	 */
	CommodityForm findForm(int id);

	/**
	 * Adds chosen {@code Country} to chosen {@code Commodity}
	 * @param idComm id of chosen {@code Commodity}
	 * @param idCountry id of chosen {@code Country}
	 */
	void addCountryToComm(int idComm, int idCountry);

	/**
	 * Adds chosen {@code Color} to chosen {@code Commodity}
	 * @param idComm id of chosen {@code Commodity}
	 * @param idColor id of chosen {@code Color}
	 */
	void addColorToComm(int idComm, int idColor);

	/**
	 * Adds chosen {@code Category} to chosen {@code Commodity}
	 * @param idComm id of chosen {@code Commodity}
	 * @param idCategory id of chosen {@code Category}
	 */
	void addCategoryToComm(int idComm, int idCategory);

	/**
	 * Finds {@code Commodity}'s with related {@code Category} id same as parameter
	 * @param id id of {@code Category} you are looking for
	 * @return List of found Commodities
	 */
	List<Commodity> findByCategoryId(int id);

	/**
	 * Finds {@code Commodity} with same name as parameter
	 * @param name name of {@code Commodity} you want to find
	 * @return found {@code Commodity}
	 */
	Commodity findByName(String name);

	/**
	 * Finds all {@code Commodity}'s in page perspective
	 * @param filter used filter
	 * @param pageable pagination information
	 * @return pages of found {@code Commodity}'s
	 */
	Page<Commodity> findAll(Pageable pageable, CommodityFilter filter);

	/**
	 * Finds random {@code Commodity}'s in DB
	 * @param quantityOfCommodities quantity of random {@code Commodity}'s you want to find
	 * @return List of found {@code Commodity}'s
	 */
	List<Commodity> getRandomCommodities(int quantityOfCommodities);
}
