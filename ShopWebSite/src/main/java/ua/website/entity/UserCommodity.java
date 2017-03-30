package ua.website.entity;

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
	
	public UserCommodity() {
	}

	

	public UserCommodity(int number, User user, Commodity commodity,SaleStatus status) {
		this.number = number;
		this.user = user;
		this.commodity = commodity;
		this.status = status;
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
	
	
	
	
}
