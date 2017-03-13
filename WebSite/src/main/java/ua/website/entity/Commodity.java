package ua.website.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="commodity")
public class Commodity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="_name")
	private String name;
	
	@Column(name="_price")
	private BigDecimal price;
	
	@Column(name="_description")
	private String description;
	
	@Column(name="_version")
	private int version;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Country country;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Color color;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Subcategory subcategory;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Fabricator fabricator;
	

	

	@ManyToMany
	@JoinTable(name="commodity_user",
	joinColumns=@JoinColumn(name="id_commodity"),
	inverseJoinColumns=@JoinColumn(name="id_user"))
	private List<User> users;
	
	
	public Commodity() {
	}


	public Commodity(String name, BigDecimal price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public Subcategory getSubcategory() {
		return subcategory;
	}


	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	


	public Fabricator getFabricator() {
		return fabricator;
	}


	public void setFabricator(Fabricator fabricator) {
		this.fabricator = fabricator;
	}


	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", price=" + price
				+ ", description=" + description + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commodity other = (Commodity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
