package ua.website.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static volatile SingularAttribute<Category, String> name;
	public static volatile ListAttribute<Category, Commodity> commodities;
	public static volatile SingularAttribute<Category, Integer> id;
	public static volatile ListAttribute<Category, Subcategory> subcategories;

}

