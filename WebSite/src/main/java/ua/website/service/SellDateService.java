package ua.website.service;

import java.util.List;

import ua.website.entity.SellDate;

public interface SellDateService {
	void save(SellDate sellDate);
	List<SellDate> findAll();
	SellDate findOne(int id);
	void delete(int id);
	void update(SellDate sellDate);
}
