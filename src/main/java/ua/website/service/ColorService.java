package ua.website.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.website.dto.filter.SimpleFilter;
import ua.website.entity.Color;

/**
 * Service interface that works with {@code Color} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Color
 * @see ua.website.dao.ColorDao
 * @see ua.website.serviceImpl.ColorServiceImpl
 */
public interface ColorService {

	/**
	 * Saves {@code Color} in DataBase
	 * @param color {@code Color} you want to save
	 */
	void save(Color	color);

	/**
	 * Finds all {@code Color}'s in DataBase
	 * @return List of found {@code Color}'s
	 */
	List<Color> findAll();

	/**
	 * Finds {@code Color} with same id as parameter
	 * @param id id of {@code Color} you want to find
	 * @return found {@code Color}
	 */
	Color findOne(int id);

	/**
	 * Deletes {@code Color} with same id as parameter
	 * @param id id of {@code Color} you want to delete
	 */
	void delete(int id);

	/**
	 * Updates {@code Color} specified in parameter
	 * @param color {@code Color} you want to update
	 */
	void update(Color color);

	/**
	 * Finds {@code Color} with same name as parameter
	 * @param name name of {@code Color} you want to find
	 * @return found {@code Color}
	 */
	Color findByName(String name);

	/**
	 * Finds all {@code Color} in page perspective
	 * @param filter used filter
	 * @param pageable pagination information
	 * @return pages of found {@code Color}'s
	 */
	Page<Color> findAll(SimpleFilter filter,Pageable pageable);


}

