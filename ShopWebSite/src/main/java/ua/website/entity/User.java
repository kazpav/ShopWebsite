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

	/** {@code User}'s id used as primary key*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/** {@code User}'s name represented in separate column*/
	@Column(name="_name")
	private String name;

	/** {@code User}'s email represented in separate column*/
	@Column(name="_email")
	private String email;

	/** {@code User}'s password represented in separate column */
	@Column(name="_password")
	private String password;

	/**
	 * {@code User}'s enumerated role used to identify user's opportunities during using website
	 * @see ua.website.entity.Role
	 */
	@Enumerated
	@Column(name="_role")
	private Role role;

	/** Used to confirm user's password during registration, it's not store in DB */
	@Transient
	private String repeatPassword;

	/** List of purchased commodities
	 * from {@code UserCommodity} adjacent table
	 * used for making ManyToMany connection
	 * @see ua.website.entity.UserCommodity
	 */
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<UserCommodity> userCommodities;

	/**
	 * Default constructor.
	 * Initializes a newly created {@code User} with empty fields
	 */
	public User() {
	}

	/**
	 * Constructor; initializes a newly created {@code User} with it's fields
	 * @param name {@code User}'s new name
	 * @param email {@code User}'s new email
	 * @param password {@code User}'s new password
	 */
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	/**
	 * Getter for {@code User}'s id
	 * @return this {@code User}'s id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for {@code User}'s id,
	 * changes this {@code User}'s id
	 * @param id this {@code User}'s new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for {@code User}'s name
	 * @return this {@code User}'s name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for {@code User}'s name
	 * changes this {@code User}'s name
	 * @param name this {@code User}'s new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for {@code User}'s email
	 * @return this {@code User}'s email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter for {@code User}'s email
	 * changes this {@code User}'s email
	 * @param email this {@code User}'s new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter for {@code User}'s password
	 * @return this {@code User}'s password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for {@code User}'s password
	 * changes this {@code User}'s password
	 * @param password this {@code User}'s new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter for this {@code User}'s role
	 * @return this {@code User}'s role
	 * @see ua.website.entity.Role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Setter for this {@code User}'s role
	 * changes this {@code User}'s role
	 * @param role this {@code User}'s new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Getter for this {@code User}'s repeated password
	 * @return this {@code User}'s repeated password
	 */
	public String getRepeatPassword() {
		return repeatPassword;
	}

	/**
	 * Setter for this {@code User}'s repeated password
	 * changes this {@code User}'s repeated password
	 * @param repeatPassword this {@code User}'s new repeated password
	 */
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	/**
	 * Getter for this {@code User}'s {@code Commodity}'s
	 * @return List of this {@code User}'s {@code Commodity}'s
	 */
	public List<UserCommodity> getUserCommodities() {
		return userCommodities;
	}

	/**
	 * Setter for this {@code User}'s {@code Commodity}'s
	 * @param userCommodities this {@code User}'s new List of {@code Commodity}'s
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
	 * @return hash code of this object
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
	 * @return this {@code User}'s authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(role.name())));
	}

	/**
	 * Returns the username (email in this case) used to authenticate the user.
	 * @return this {@code User}'s email
	 */
	@Override
	public String getUsername() {
		return email;
	}

	/**
	 * Indicates whether the {@code User}'s account has expired.
	 * @return boolean value
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Indicates whether the {@code User} is locked or unlocked.
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
