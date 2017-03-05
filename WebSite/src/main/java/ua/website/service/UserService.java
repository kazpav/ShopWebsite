package ua.website.service;

import java.util.List;

import ua.website.entity.User;

public interface UserService {

	void save(User user);
	List<User> findAll();
	User findOne(int id);
	void delete(int id);
	void update(User user);
//	void AddCountryToUser(int idUser, int idCountry);
//	void AddCityToUser(int idUser, int idCity);
	User findByName(String name);
//	User fetchUserWithCommod(String name);
//	public void addCommodityToUser(int UserId, int CommodId);
}
