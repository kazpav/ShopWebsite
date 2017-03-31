package ua.website.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="userCommodity")
public class UserCommodity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="_number")
	private int number;
	
	@Enumerated
	@Column(name="_status")
	private SaleStatus status;
	

	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	@ManyToOne(fetch=FetchType.LAZY)
	private Commodity commodity;
	@ManyToOne(fetch=FetchType.LAZY)
	private PurchaseContact purchaseContact;
	
	public UserCommodity() {
	}


	public UserCommodity(int number, SaleStatus status, User user, Commodity commodity,
			PurchaseContact purchaseContact) {
		this.number = number;
		this.status = status;
		this.user = user;
		this.commodity = commodity;
		this.purchaseContact = purchaseContact;
	}







	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}



	public SaleStatus getStatus() {
		return status;
	}



	public void setStatus(SaleStatus status) {
		this.status = status;
	}


	public PurchaseContact getPurchaseContact() {
		return purchaseContact;
	}


	public void setPurchaseContact(PurchaseContact purchaseContact) {
		this.purchaseContact = purchaseContact;
	}
	
	
}
