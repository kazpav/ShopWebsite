package ua.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.website.dao.ColorDao;
import ua.website.dto.filter.SimpleFilter;
import ua.website.entity.Color;
import ua.website.service.ColorService;
@Service
public class ColorServiceImpl implements ColorService{

	@Autowired
	private ColorDao colorDao;
	
	public void save(Color color) {
		color.getName().toUpperCase();
		colorDao.save(color);
	}

	public List<Color> findAll() {
		return colorDao.findAll();
	}

	public Color findOne(int id) {
		return colorDao.findOne(id);
	}

	public void delete(int id) {
		colorDao.delete(id);
	}

	public void update(Color color) {
		colorDao.save(color);
	}

	public Color findByName(String name) {
		return colorDao.findByName(name);
	}

	@Override
	public Page<Color> findAll(SimpleFilter filter, Pageable pageable) {
		return colorDao.findAll(findByNameLike(filter),pageable);
	}

	private Specification<Color> findByNameLike(SimpleFilter filter) {
		return (root,query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch().toLowerCase()+"%");
		};
	}

}
