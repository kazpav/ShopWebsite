package ua.website.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Fabricator.class)
public abstract class Fabricator_ {

	public static volatile SingularAttribute<Fabricator, String> name;
	public static volatile ListAttribute<Fabricator, Commodity> commodities;
	public static volatile SingularAttribute<Fabricator, Integer> id;

}

