package ua.website.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.website.dao.PurchaseContactDao;
import ua.website.dto.form.PurchaseContactForm;
import ua.website.entity.PurchaseContact;
import ua.website.service.PurchaseContactService;

/**
 * Service that works with {@code PurchaseContact} entities
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.PurchaseContact
 * @see ua.website.dao.PurchaseContactDao
 * @see ua.website.service.PurchaseContactService
 */
@Service
public class PurchaseContactServieImpl implements PurchaseContactService {

	/** Dependency Injection of {@code PurchaseContact} */
	@Autowired
	private PurchaseContactDao purchaseContactDao;

	/**
	 * Saves {@code PurchaseContact} in DataBase
	 * @param purchaseContact {@code PurchaseContact} you want to save
	 */
	@Override
	public void save(PurchaseContact purchaseContact) {
		purchaseContactDao.save(purchaseContact);
	}

	/**
	 * Finds all {@code PurchaseContact}'s in DataBase
	 * @return List of found {@code PurchaseContact}'s
	 */
	@Override
	public List<PurchaseContact> findAll() {
		return purchaseContactDao.findAll();
	}

	/**
	 * Finds {@code PurchaseContact} with same id as parameter
	 * @param id id of {@code PurchaseContact} you want to find
	 * @return found {@code PurchaseContact}
	 */
	@Override
	public PurchaseContact findOne(int id) {
		return purchaseContactDao.findOne(id);
	}

	/**
	 * Deletes {@code PurchaseContact} with same id as parameter
	 * @param id id of {@code PurchaseContact} you want to delete
	 */
	@Override
	public void delete(int id) {
		purchaseContactDao.delete(id);
	}

	/**
	 * Updates {@code PurchaseContact} specified in parameter
	 * @param purchaseContacts {@code PurchaseContact} you want to update
	 */
	@Override
	public void update(PurchaseContact purchaseContacts) {
		purchaseContactDao.save(purchaseContacts);
	}

	/**
	 * Converts {@code PurchaseContactForm} objects to {@code PurchaseContact}
	 * @param purchaseContactForm object you want to convert
	 * @return converted object
	 */
	@Override
	public PurchaseContact convertFormToEntity(PurchaseContactForm purchaseContactForm) {
		PurchaseContact entity = new PurchaseContact();
		entity.setId(purchaseContactForm.getId());
		entity.setAddress(purchaseContactForm.getAddress());
		entity.setContactNumber(Integer.valueOf(purchaseContactForm
				.getContactNumber()));
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		try {
			entity.setDate(formatter.parse(purchaseContactForm.getDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entity.setFullName(purchaseContactForm.getFullName());
		return entity;
	}

}
