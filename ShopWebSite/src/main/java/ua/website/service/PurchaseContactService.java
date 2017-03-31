package ua.website.service;

import java.util.List;

import ua.website.dto.form.PurchaseContactForm;
import ua.website.entity.PurchaseContact;
import ua.website.entity.SaleStatus;

public interface PurchaseContactService {
	
	void save(PurchaseContact purchaseContact);
	List<PurchaseContact> findAll();
	PurchaseContact findOne(int id);
	void delete(int id);
	void update(PurchaseContact purchaseContact);
	PurchaseContact convertFormToEntity(PurchaseContactForm purchaseContactForm);
//	List<PurchaseContact> findPurchasesByStatus(SaleStatus status);

}
