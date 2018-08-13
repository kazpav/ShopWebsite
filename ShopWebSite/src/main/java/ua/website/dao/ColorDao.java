package ua.website.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.website.entity.Color;

/**
 * Data Access Object interface provides connection
 * between Color Objects in application and DB
 * using JpaRepository to make main requests to DataBase
 * and JpaSpecificationExecutor  to allow execution of Specification
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Color
 * @see ua.website.serviceImpl.ColorServiceImpl
 */
public interface ColorDao extends JpaRepository<Color, Integer>,JpaSpecificationExecutor<Color> {

	Color findByName(String name);
}
