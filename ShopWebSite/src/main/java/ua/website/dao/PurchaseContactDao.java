package ua.website.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import ua.website.entity.PurchaseContact;

/**
 * Data Access Object interface provides connection
 * between {@code PurchaseContact} Objects in application and DB
 * using JpaRepository to make main requests to DataBase
 * and JpaSpecificationExecutor  to allow execution of Specification
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Color
 * @see ua.website.serviceImpl.ColorServiceImpl
 */
public interface PurchaseContactDao extends JpaRepository<PurchaseContact, Integer>{

}
