package ua.website.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="purchaseContact")
public class PurchaseContact{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="_fullName")
	private String fullName;
	
	@Column(name="_contactNumber")
	private int contactNumber;
	
	@Column(name="_address")
	private String address;
	
	@Column(name="_saleDate")
	private Date date;
	
	
	
	@OneToMany(mappedBy="purchaseContact",fetch=FetchType.LAZY)
	private List<UserCommodity> userCommodities;
	
	public PurchaseContact() {
	}

	public PurchaseContact(String fullName, int contactNumber, String address,
			Date date) {
		this.fullName = fullName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int  contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
}
