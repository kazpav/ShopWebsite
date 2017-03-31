package ua.website.dto.form;



import java.util.Date;

import ua.website.entity.Commodity;
import ua.website.entity.SaleStatus;
import ua.website.entity.User;

public class UserCommodityForm {

	
	private int id;
	
	private String number;
	
	private SaleStatus status;
	


	
	private User user;
	private Commodity commodity;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	public SaleStatus getStatus() {
		return status;
	}
	public void setStatus(SaleStatus status) {
		this.status = status;
	}
		
}
