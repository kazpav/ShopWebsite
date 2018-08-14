package ua.website.service;

import java.util.List;

import ua.website.dto.form.PurchaseContactForm;
import ua.website.entity.PurchaseContact;

/**
 * Service interface that works with {@code PurchaseContact} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.PurchaseContact
 * @see ua.website.dao.PurchaseContactDao
 * @see ua.website.serviceImpl.PurchaseContactServieImpl
 */
public interface PurchaseContactService {

	/**
	 * Saves {@code PurchaseContact} in DataBase
	 * @param purchaseContact {@code PurchaseContact} you want to save
	 */
	void save(PurchaseContact purchaseContact);

	/**
	 * Finds all {@code PurchaseContact}'s in DataBase
	 * @return List of found {@code PurchaseContact}'s
	 */
	List<PurchaseContact> findAll();

	/**
	 * Finds {@code PurchaseContact} with same id as parameter
	 * @param id id of {@code PurchaseContact} you want to find
	 * @return found {@code PurchaseContact}
	 */
	PurchaseContact findOne(int id);

	/**
	 * Deletes {@code PurchaseContact} with same id as parameter
	 * @param id id of {@code PurchaseContact} you want to delete
	 */
	void delete(int id);

	/**
	 * Updates {@code PurchaseContact} specified in parameter
	 * @param purchaseContact {@code PurchaseContact} you want to update
	 */
	void update(PurchaseContact purchaseContact);

	/**
	 * Converts {@code PurchaseContactForm} objects to {@code PurchaseContact}
	 * @param purchaseContactForm object you want to convert
	 * @return converted object
	 */
	PurchaseContact convertFormToEntity(PurchaseContactForm purchaseContactForm);

}
