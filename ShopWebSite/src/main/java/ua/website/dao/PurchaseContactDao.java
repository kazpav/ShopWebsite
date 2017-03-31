package ua.website.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.website.entity.PurchaseContact;
import ua.website.entity.SaleStatus;

public interface PurchaseContactDao extends JpaRepository<PurchaseContact, Integer>{
//	@Query("SELECT p FROM PurchaseContact p LEFT JOIN FETCH p.userCommodities WHERE p.userCommodity.status=?1")
//	List<PurchaseContact> findPurchasesByStatus(SaleStatus status);
}
