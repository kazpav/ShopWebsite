package ua.website.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p> POJO class representing Users
 * labeled with persistence annotations
 * using Spring Security libraries for security purposes </p>
 * @author Pavel Kazarin
 * @version 1.0
 * @see org.springframework.security.core.userdetails.UserDetails
 */
@Entity
@Table(name="user")
public class User implements UserDetails {

	/** Generated Serial Version UID*/
	private static final long serialVersionUID = 2518803236411276944L;

	/** User's id used as primary key*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** User's name represented in separate column*/
	@Column(name="_name")
	private String name;

	/** User's email represented in separate column*/
	@Column(name="_email")
	private String email;

	/** User's password represented in separate column */
	@Column(name="_password")
	private String password;

	/**
	 * User's enumerated role used to identify user's opportunities during using website
	 * @see ua.website.entity.Role
	 */
	@Enumerated
	@Column(name="_role")
	private Role role;

	/** Used to confirm user's password during registration, it's not store in DB */
	@Transient
	private String repeatPassword;

	/** List of purchased commodities
	 * from UserCommodity adjacent table
	 * used instead ManyToMany connection
	 * @see ua.website.entity.UserCommodity
	 */
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<UserCommodity> userCommodities;

	/**
	 * Default constructor; initializes a newly created User with empty fields
	 */
	public User() {
	}

	/**
	 * Constructor; initializes a newly created User with it's fields
	 * @param name User's name
	 * @param email User's email
	 * @param password User's password
	 */
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	/**
	 * Getter for User's id
	 * @return this User's id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for User's id,
	 * changes this User's id
	 * @param id this User's new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for User's name
	 * @return this User's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for User's name
	 * changes this User's name
	 * @param name this User's new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for User's email
	 * @return this User's email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter for User's email
	 * changes this User's email
	 * @param email this User's new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter for User's password
	 * @return this User's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for User's password
	 * changes this User's password
	 * @param password this User's new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter for this User's role
	 * @return this User's role
	 * @see ua.website.entity.Role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Setter for this User's role
	 * changes this User's role
	 * @param role this User's new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Getter for this User's repeated password
	 * @return this User's repeated password
	 */
	public String getRepeatPassword() {
		return repeatPassword;
	}

	/**
	 * Setter for this User's repeated password
	 * changes this User's repeated password
	 * @param repeatPassword this User's new repeated password
	 */
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	/**
	 * Getter for this User's Commodities
	 * @return List of this User's Commodities
	 */
	public List<UserCommodity> getUserCommodities() {
		return userCommodities;
	}

	/**
	 * Setter for this User's Commodities
	 * @param userCommodities this User's new List of Commodities
	 */
	public void setUserCommodities(List<UserCommodity> userCommodities) {
		this.userCommodities = userCommodities;
	}

	/**
	 * realization of toString method
	 * @return String representation of this Object
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email
				+ ", password=" + password + "]";
	}

	/**
	 * Generates and returns hash code
	 * @return hash code for this object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Compares two objects
	 * @param obj Object to compare
	 * @return if this object is the same as the object argument
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * Returns the authorities granted to the user.
	 * @return this User's authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(role.name())));
	}

	/**
	 * Returns the username (email in this case) used to authenticate the user.
	 * @return this User's email
	 */
	@Override
	public String getUsername() {
		return email;
	}

	/**
	 * Indicates whether the user's account has expired.
	 * @return boolean value
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Indicates whether the user is locked or unlocked.
	 * @return boolean value
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Indicates whether the user's credentials (password) has expired.
	 * @return boolean value
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Indicates whether the user is enabled or disabled.
	 * @return boolean value
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}



	
	
}
