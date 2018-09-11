package ua.website.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.website.dao.FabricatorDao;
import ua.website.dto.filter.SimpleFilter;
import ua.website.entity.Fabricator;
import ua.website.service.FabricatorService;

/**
 * Service that works with {@code Fabricator} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Fabricator
 * @see ua.website.dao.FabricatorDao
 * @see ua.website.service.FabricatorService
 */
@Service
public class FabricatorServiceImpl implements FabricatorService {

	/** Dependency Injection of {@code FabricatorDao} */
	@Autowired
	private FabricatorDao fabricatorDao;

	/**
	 * Saves {@code Fabricator} in DataBase
	 * @param fabricator {@code Fabricator} you want to save
	 */
	@Override
	public void save(Fabricator fabricator) {
		fabricator.getName().toUpperCase();
		fabricatorDao.save(fabricator);
	}

	/**
	 * Finds all {@code Fabricator}'s in DataBase
	 * @return List of found {@code Fabricator}'s
	 */
	@Override
	public List<Fabricator> findAll() {
		return fabricatorDao.findAll();
	}

	/**
	 * Finds {@code Fabricator} with same id as parameter
	 * @param id id of {@code Fabricator} you want to find
	 * @return found {@code Fabricator}
	 */
	@Override
	public Fabricator findOne(int id) {
		return fabricatorDao.findOne(id);
	}

	/**
	 * Deletes {@code Fabricator} with same id as parameter
	 * @param id id of {@code Fabricator} you want to delete
	 */
	@Override
	public void delete(int id) {
		fabricatorDao.delete(id);
	}

	/**
	 * Updates {@code Fabricator} specified in parameter
	 * @param fabricator {@code Fabricator} you want to update
	 */
	@Override
	public void update(Fabricator fabricator) {
		fabricatorDao.save(fabricator);
	}

	/**
	 * Finds {@code Fabricator} with same name as parameter
	 * @param name name of {@code Fabricator} you want to find
	 * @return found {@code Fabricator}
	 */
	@Override
	public Fabricator findByName(String name) {
		return fabricatorDao.findByName(name);
	}

	/**
	 * Finds all {@code Fabricator}'s in page perspective
	 * @param filter used filter
	 * @param pageable pagination information
	 * @return pages of found {@code Fabricator}'s
	 */
	@Override
	public Page<Fabricator> findAll(SimpleFilter filter, Pageable pageable) {
		return fabricatorDao.findAll(findByNameLike(filter),pageable);
	}

	private Specification<Fabricator> findByNameLike(SimpleFilter filter) {
		return (root,query,cb)->{
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch().toLowerCase()+"%");
		};
	}

}
