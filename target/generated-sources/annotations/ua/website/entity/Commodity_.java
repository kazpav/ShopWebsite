package ua.website.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Commodity.class)
public abstract class Commodity_ {

	public static volatile SingularAttribute<Commodity, Country> country;
	public static volatile ListAttribute<Commodity, UserCommodity> userCommodities;
	public static volatile SingularAttribute<Commodity, Integer> quantity;
	public static volatile SingularAttribute<Commodity, Fabricator> fabricator;
	public static volatile SingularAttribute<Commodity, Color> color;
	public static volatile SingularAttribute<Commodity, BigDecimal> price;
	public static volatile SingularAttribute<Commodity, String> name;
	public static volatile SingularAttribute<Commodity, String> description;
	public static volatile SingularAttribute<Commodity, Integer> id;
	public static volatile SingularAttribute<Commodity, Subcategory> subcategory;
	public static volatile SingularAttribute<Commodity, Category> category;
	public static volatile SingularAttribute<Commodity, Integer> version;

}

