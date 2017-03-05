package ua.website.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.website.dao.CategoryDao;
import ua.website.dao.ColorDao;
import ua.website.dao.CommodityDao;
import ua.website.dao.CountryDao;
import ua.website.dto.form.CommodityForm;
import ua.website.entity.Category;
import ua.website.entity.Color;
import ua.website.entity.Commodity;
import ua.website.entity.Country;
import ua.website.service.CommodityService;
@Service
public class CommodityServiceImpl implements CommodityService{
	
	@Autowired
	private CommodityDao commDao;
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private ColorDao colorDao;
	@Autowired
	private CategoryDao categDao;

	public void save(CommodityForm form) {
		Commodity entity = new Commodity();
		entity.setPrice(new BigDecimal(form.getPrice().replace(',', '.')));
		entity.setCategory(form.getCategory());
		entity.setColor(form.getColor());
		entity.setCountry(form.getCountry());
		entity.setDescription(form.getDescription());
		entity.setFabricator(form.getFabricator());
		entity.setId(form.getId());
		entity.setName(form.getName());
		entity.setSubcategory(form.getSubcategory());
		commDao.save(entity);
		
	}

	public List<Commodity> findAll() {
		return commDao.findAll();
	}

	public Commodity findOne(int id) {
		return commDao.findOne(id);
	}

	public void delete(int id) {
		commDao.delete(id);
	}

	public void update(Commodity commodity) {
		commDao.save(commodity);
	}

	public void addCountryToComm(int idComm, int idCountry) {
		Commodity commodity = commDao.findOne(idComm);
		Country country = countryDao.findOne(idCountry);
		commDao.save(commodity);
	}

	public void addColorToComm(int idComm, int idColor) {
		Commodity commodity = commDao.findOne(idComm);
		Color color = colorDao.findOne(idColor);
		commDao.save(commodity);
	}

	public void addCategoryToComm(int idComm, int idCategory) {
		Commodity commodity = commDao.findOne(idComm);
		Category category = categDao.findOne(idCategory);
		commodity.setCategory(category);
		commDao.save(commodity);
	}

	public List<Commodity> findByCategoryId(int id){
		return commDao.findByCategoryId(id);
		
		
	}

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
		return form;
	}

	public Commodity findByName(String name) {
		return commDao.findByName(name);
	}

}
