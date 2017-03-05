package ua.website.service;

import java.util.List;

import ua.website.entity.Fabricator;

public interface FabricatorService {
	void save(Fabricator fabricator);
	List<Fabricator> findAll();
	Fabricator findOne(int id);
	void delete(int id);
	void update(Fabricator fabricator);
	Fabricator findByName(String name);
}
