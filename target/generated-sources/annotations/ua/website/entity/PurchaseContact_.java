package ua.website.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PurchaseContact.class)
public abstract class PurchaseContact_ {

	public static volatile SingularAttribute<PurchaseContact, Date> date;
	public static volatile ListAttribute<PurchaseContact, UserCommodity> userCommodities;
	public static volatile SingularAttribute<PurchaseContact, String> address;
	public static volatile SingularAttribute<PurchaseContact, Integer> contactNumber;
	public static volatile SingularAttribute<PurchaseContact, String> fullName;
	public static volatile SingularAttribute<PurchaseContact, Integer> id;

}

