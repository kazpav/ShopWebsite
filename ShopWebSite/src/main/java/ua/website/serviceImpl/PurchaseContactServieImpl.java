package ua.website.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.website.dao.PurchaseContactDao;
import ua.website.dto.form.PurchaseContactForm;
import ua.website.entity.PurchaseContact;
import ua.website.entity.SaleStatus;
import ua.website.service.PurchaseContactService;

@Service
public class PurchaseContactServieImpl implements PurchaseContactService {

	@Autowired
	private PurchaseContactDao purchaseContactDao;

	@Override
	public void save(PurchaseContact purchaseContact) {
		purchaseContactDao.save(purchaseContact);
	}

	@Override
	public List<PurchaseContact> findAll() {
		return purchaseContactDao.findAll();
	}

	@Override
	public PurchaseContact findOne(int id) {
		return purchaseContactDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		purchaseContactDao.delete(id);
	}

	@Override
	public void update(PurchaseContact purchaseContacts) {
		purchaseContactDao.save(purchaseContacts);
	}

	@Override
	public PurchaseContact convertFormToEntity(PurchaseContactForm purchaseContactForm) {
		PurchaseContact entity = new PurchaseContact();
		entity.setId(purchaseContactForm.getId());
		entity.setAddress(purchaseContactForm.getAddress());
		entity.setContactNumber(Integer.valueOf(purchaseContactForm
				.getContactNumber()));
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			entity.setDate(formatter.parse(purchaseContactForm.getDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entity.setFullName(purchaseContactForm.getFullName());
		return entity;
	}

//	@Override
//	public List<PurchaseContact> findPurchasesByStatus(SaleStatus status) {
//		return purchaseContactDao.findPurchasesByStatus(status);
//	}
}
