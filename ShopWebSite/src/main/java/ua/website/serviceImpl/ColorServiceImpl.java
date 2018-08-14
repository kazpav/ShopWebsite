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

/**
 * Service that works with {@code Color} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Color
 * @see ua.website.dao.ColorDao
 * @see ua.website.service.ColorService
 */
@Service
public class ColorServiceImpl implements ColorService{

	/** Dependency injection of {@code ColorDao} */
	@Autowired
	private ColorDao colorDao;

	/**
	 * Saves {@code Color} in DataBase
	 * @param color {@code Color} you want to save
	 */
	@Override
	public void save(Color color) {
		color.getName().toUpperCase();
		colorDao.save(color);
	}

	/**
	 * Finds all {@code Color}'s in DataBase
	 * @return List of found {@code Color}'s
	 */
	@Override
	public List<Color> findAll() {
		return colorDao.findAll();
	}

	/**
	 * Finds {@code Color} with same id as parameter
	 * @param id id of {@code Color} you want to find
	 * @return found {@code Color}
	 */
	@Override
	public Color findOne(int id) {
		return colorDao.findOne(id);
	}

	/**
	 * Deletes {@code Color} with same id as parameter
	 * @param id id of {@code Color} you want to delete
	 */
	@Override
	public void delete(int id) {
		colorDao.delete(id);
	}

	/**
	 * Updates {@code Color} specified in parameter
	 * @param color {@code Color} you want to update
	 */
	@Override
	public void update(Color color) {
		colorDao.save(color);
	}

	/**
	 * Finds {@code Color} with same name as parameter
	 * @param name name of {@code Color} you want to find
	 * @return found {@code Color}
	 */
	@Override
	public Color findByName(String name) {
		return colorDao.findByName(name);
	}

	/**
	 * Finds all {@code Color} in page perspective
	 * @param filter used filter
	 * @param pageable pagination information
	 * @return pages of found {@code Color}'s
	 */
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
