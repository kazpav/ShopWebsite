package ua.website.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.website.dto.filter.CommodityFilter;
import ua.website.dto.form.CommodityForm;
import ua.website.entity.Commodity;

public interface CommodityService {
	void saveForm(CommodityForm form);
	void save(Commodity commodity);
	List<Commodity> findAll();
	Commodity findOne(int id);
	void delete(int id);
	void update(Commodity commodity);
	
	CommodityForm findForm(int id);
	
	
	void addCountryToComm(int idComm, int idCountry);
	void addColorToComm(int idComm, int idColor);
	void addCategoryToComm(int idComm, int idCategory);
	
	List<Commodity> findByCategoryId(int id);
	Commodity findByName(String name);
	Page<Commodity> findAll(Pageable pageable, CommodityFilter filter);
	List<Commodity> getRandomCommodities(int quantityOfCommodities);
}
