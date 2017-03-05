package ua.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.website.dao.FabricatorDao;
import ua.website.entity.Fabricator;
import ua.website.service.FabricatorService;


@Service
public class FabricatorServiceImpl implements FabricatorService {
	
	@Autowired
	private FabricatorDao fabricatorDao;

	public void save(Fabricator fabricator) {
		fabricator.getName().toUpperCase();
		fabricatorDao.save(fabricator);
	}

	public List<Fabricator> findAll() {
		return fabricatorDao.findAll();
	}

	public Fabricator findOne(int id) {
		return fabricatorDao.findOne(id);
	}

	public void delete(int id) {
		fabricatorDao.delete(id);
	}

	public void update(Fabricator fabricator) {
		fabricatorDao.save(fabricator);
	}

	public Fabricator findByName(String name) {
		return fabricatorDao.findByName(name);
	}
}
