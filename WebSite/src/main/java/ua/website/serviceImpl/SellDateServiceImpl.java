package ua.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.website.dao.SellDateDao;
import ua.website.entity.SellDate;
import ua.website.service.SellDateService;


@Service
public class SellDateServiceImpl implements SellDateService {

	
	@Autowired
	private SellDateDao sellDateDao;

	public void save(SellDate sellDate) {
		sellDateDao.save(sellDate);
	}

	public List<SellDate> findAll() {
		return sellDateDao.findAll();
	}

	public SellDate findOne(int id) {
		return sellDateDao.findOne(id);
	}

	public void delete(int id) {
		sellDateDao.delete(id);
		
	}

	public void update(SellDate sellDate) {
		sellDateDao.save(sellDate);
		
	}
}
