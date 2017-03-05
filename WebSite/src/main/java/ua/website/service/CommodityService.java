package ua.website.service;

import java.util.List;

import ua.website.dto.form.CommodityForm;
import ua.website.entity.Commodity;

public interface CommodityService {
	void save(CommodityForm amount);
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
}
