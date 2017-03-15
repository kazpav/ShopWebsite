package ua.website.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.website.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
//	public void save(User user);
//
//	public void delete(int id);
//
//	public User findOne(int id);
//
//	public List<User> findAll();
//	void update(User user);
	
	User findByName(String name);
	User findByEmail(String email);
//	public void addCommodityToUser(int UserId, int CommodId);
	
//	@Query("select u from User u left join fetch u.commodity where u.name=:param")
//	User fetchUserWithCommod(@Param("param")String name);
}
