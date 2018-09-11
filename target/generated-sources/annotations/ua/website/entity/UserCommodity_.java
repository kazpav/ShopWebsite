package ua.website.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserCommodity.class)
public abstract class UserCommodity_ {

	public static volatile SingularAttribute<UserCommodity, Integer> number;
	public static volatile SingularAttribute<UserCommodity, Commodity> commodity;
	public static volatile SingularAttribute<UserCommodity, PurchaseContact> purchaseContact;
	public static volatile SingularAttribute<UserCommodity, Integer> id;
	public static volatile SingularAttribute<UserCommodity, User> user;
	public static volatile SingularAttribute<UserCommodity, SaleStatus> status;

}

