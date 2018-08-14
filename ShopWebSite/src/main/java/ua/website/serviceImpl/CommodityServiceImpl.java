package ua.website.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.website.dao.CategoryDao;
import ua.website.dao.ColorDao;
import ua.website.dao.CommodityDao;
import ua.website.dao.CountryDao;
import ua.website.dto.filter.CommodityFilter;
import ua.website.dto.form.CommodityForm;
import ua.website.entity.Category;
import ua.website.entity.Color;
import ua.website.entity.Commodity;
import ua.website.entity.Country;
import ua.website.service.CommodityService;
import ua.website.service.FileWriter;
import ua.website.service.FileWriter.Folder;
import ua.website.specification.CommoditySpecification;

/**
 * Service that works with {@code Commodity} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 * @see ua.website.dao.CommodityDao
 * @see ua.website.service.CommodityService
 */
@Service
public class CommodityServiceImpl implements CommodityService{

	/** Dependency injection of {@code CommodityDao} */
	@Autowired
	private CommodityDao commDao;

	/** Dependency injection of {@code CountryDao} */
	@Autowired
	private CountryDao countryDao;

	/** Dependency injection of {@code ColorDao} */
	@Autowired
	private ColorDao colorDao;

	/** Dependency injection of {@code CategoryDao} */
	@Autowired
	private CategoryDao categDao;

	/** Dependency injection of {@code FileWriter} */
	@Autowired
	private FileWriter fileWriter;

	/**
	 * Saves {@code Commodity} converted from {@code CommodityForm}
	 * @param form {@code CommodityForm} you want to convert
	 */
	@Override
	public void saveForm(CommodityForm form) {
		Commodity entity = new Commodity();
		entity.setPrice(new BigDecimal(form.getPrice().replace(',', '.')));
		entity.setCategory(form.getCategory());
		entity.setColor(form.getColor());
		entity.setCountry(form.getCountry());
		entity.setDescription(form.getDescription());
		entity.setFabricator(form.getFabricator());
		entity.setId(form.getId());
		entity.setName(form.getName());
		entity.setQuantity(new Integer(form.getQuantity()));
		entity.setSubcategory(form.getSubcategory());
		entity = commDao.saveAndFlush(entity);
		if(fileWriter.write(Folder.COMMODITY, form.getFile(), entity.getId())){
			entity.setVersion(form.getVersion()+1);
			commDao.save(entity);
		}
	}

	/**
	 * Saves {@code Commodity} in DataBase
	 * @param commodity {@code Commodity} you want to save
	 */
	@Override
	public void save(Commodity commodity) {
		commDao.save(commodity);
	}

	/**
	 * Finds all {@code Commodity}'s in DataBase
	 * @return List of found {@code Commodity}'s
	 */
	@Override
	public List<Commodity> findAll() {
		return commDao.findAll();
	}

	/**
	 * Finds {@code Commodity} with same id as parameter
	 * @param id id of {@code Commodity} you want to find
	 * @return found {@code Commodity}
	 */
	@Override
	public Commodity findOne(int id) {
		return commDao.findOne(id);
	}

	/**
	 * Deletes {@code Commodity} with same id as parameter
	 * @param id id of {@code Commodity} you want to delete
	 */
	@Override
	public void delete(int id) {
		commDao.delete(id);
	}

	/**
	 * Updates {@code Commodity} specified in parameter
	 * @param commodity {@code Commodity} you want to update
	 */
	@Override
	public void update(Commodity commodity) {
		commDao.save(commodity);
	}

	/**
	 * Adds chosen {@code Country} to chosen {@code Commodity}
	 * @param idComm id of chosen {@code Commodity}
	 * @param idCountry id of chosen {@code Country}
	 */
	@Override
	public void addCountryToComm(int idComm, int idCountry) {
		Commodity commodity = commDao.findOne(idComm);
		Country country = countryDao.findOne(idCountry);
		commDao.save(commodity);
	}

	/**
	 * Adds chosen {@code Color} to chosen {@code Commodity}
	 * @param idComm id of chosen {@code Commodity}
	 * @param idColor id of chosen {@code Color}
	 */
	@Override
	public void addColorToComm(int idComm, int idColor) {
		Commodity commodity = commDao.findOne(idComm);
		Color color = colorDao.findOne(idColor);
		commDao.save(commodity);
	}

	/**
	 * Adds chosen {@code Category} to chosen {@code Commodity}
	 * @param idComm id of chosen {@code Commodity}
	 * @param idCategory id of chosen {@code Category}
	 */
	@Override
	public void addCategoryToComm(int idComm, int idCategory) {
		Commodity commodity = commDao.findOne(idComm);
		Category category = categDao.findOne(idCategory);
		commodity.setCategory(category);
		commDao.save(commodity);
	}

	/**
	 * Finds {@code Commodity}'s with related {@code Category} id same as parameter
	 * @param id id of {@code Category} you are looking for
	 * @return List of found Commodities
	 */
	@Override
	public List<Commodity> findByCategoryId(int id){
		return commDao.findByCategoryId(id);
	}

	/**
	 * Finds {@code Commodity} by id and converts it to {@code CommodityForm}
	 * @param id {@code Commodity} you want to find
	 * @return converted {@code CommodityForm}
	 */
	@Override
	public CommodityForm findForm(int id) {
		Commodity entity = findOne(id);
		CommodityForm form = new CommodityForm();
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setCategory(entity.getCategory());
		form.setColor(entity.getColor());
		form.setCountry(entity.getCountry());
		form.setDescription(entity.getDescription());
		form.setFabricator(entity.getFabricator());
		form.setId(entity.getId());
		form.setName(entity.getName());
		form.setSubcategory(entity.getSubcategory());
		form.setVersion(entity.getVersion());
		form.setQuantity(String.valueOf(entity.getQuantity()));
		return form;
	}

	/**
	 * Finds {@code Commodity} with same name as parameter
	 * @param name name of {@code Commodity} you want to find
	 * @return found {@code Commodity}
	 */
	@Override
	public Commodity findByName(String name) {
		return commDao.findByName(name);
	}

	/**
	 * Finds all {@code Commodity}'s in page perspective
	 * @param filter used filter
	 * @param pageable pagination information
	 * @return pages of found {@code Commodity}'s
	 */
	@Override
	public Page<Commodity> findAll(Pageable pageable, CommodityFilter filter) {
		return commDao.findAll(new CommoditySpecification(filter), pageable);
	}

	/**
	 * Finds random {@code Commodity}'s in DB
	 * @param quantityOfCommodities quantity of random {@code Commodity}'s you want to find
	 * @return List of found {@code Commodity}'s
	 */
	@Override
	public List<Commodity> getRandomCommodities(int quantityOfCommodities) {
		List<Commodity> commodityList = commDao.findAll();
		List<Integer> numbers = new ArrayList<Integer>();
		List<Commodity> randomCommodities = new ArrayList<Commodity>();
		for (int i=0;i<commodityList.size();i++){
			numbers.add(new Integer(i));
		}
		Collections.shuffle(numbers);
		for(int i=0;i<quantityOfCommodities;i++){
			randomCommodities.add(commodityList.get(numbers.get(i)));
		}
		return randomCommodities;
	}

}
