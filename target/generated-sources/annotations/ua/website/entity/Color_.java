package ua.website.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Color.class)
public abstract class Color_ {

	public static volatile SingularAttribute<Color, String> name;
	public static volatile ListAttribute<Color, Commodity> commodities;
	public static volatile SingularAttribute<Color, Integer> id;

}

