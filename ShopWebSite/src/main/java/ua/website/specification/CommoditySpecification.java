package ua.website.specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.website.dto.filter.CommodityFilter;
import ua.website.entity.Commodity;

/**
 * Specification class that uses Spring Framework's Specification interface
 * for making requests to DataBase and sending back results,
 * during filtering {@code Commodity} entities on web page
 * using {@code CommodityFilter} data transfer objects
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Commodity
 * @see ua.website.dto.filter.CommodityFilter
 * @see ua.website.controller.admin.CommodityController
 * @see ua.website.dao.CommodityDao
 */
public class CommoditySpecification implements Specification<Commodity>{

	/** {@code CommodityFilter} object that comes from input form */
	private final CommodityFilter filter;

	/** List of {@code Predicate}'s */
	private final List<Predicate> predicates = new ArrayList<Predicate>();

	/** RegEx that we use to validate price input */
	private static final Pattern REG = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");


	/**
	 * Constructor that sets {@code CommodityFilter} object
	 * and validates price field
	 * @param filter {@code CommodityFilter} object that came in input
	 */
	public CommoditySpecification(CommodityFilter filter) {
		this.filter = filter;
		if(REG.matcher(filter.getMax()).matches()){
			filter.setMaxPrice(new BigDecimal(filter.getMax().replace(',', '.')));
		}
		if(REG.matcher(filter.getMax()).matches()){
			filter.setMinPrice(new BigDecimal(filter.getMin().replace(',', '.')));
		}
	}

	/**
	 * This method gets name specified by client
	 * and adds it to this {@code Predicate} object
	 * @param root root Entity
	 * @param query {@code CriteriaQuery} you use
	 * @param cb {@code CriteriaBuilder} you use
	 */
	private void findByName(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getNameSearch().isEmpty()){
			predicates.add(cb.like(root.get("name"), filter.getNameSearch()+"%"));
		}
	}

	/**
	 * This method gets max and min price specified by client
	 * and adds it to this {@code Predicate} object
	 * @param root root Entity
	 * @param query {@code CriteriaQuery} you use
	 * @param cb {@code CriteriaBuilder} you use
	 */
	private void findByPrice(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(filter.getMaxPrice()!=null){
			predicates.add(cb.le(root.get("price"), filter.getMaxPrice()));
		}
		if(filter.getMinPrice()!=null){
			predicates.add(cb.ge(root.get("price"), filter.getMinPrice()));
		}
	}

	/**
	 * This method gets {@code Country}'s specified by client
	 * and adds them to this {@code Predicate} object
	 * @param root root Entity
	 * @param query {@code CriteriaQuery} you use
	 */
	private void findByCountry(Root<Commodity> root, CriteriaQuery<?> query){
		if(!filter.getCountryId().isEmpty()){
			predicates.add(root.get("country").in(filter.getCountryId()));
		}
	}

	/**
	 * This method gets {@code Color}'s specified by client
	 * and adds them to this {@code Predicate} object
	 * @param root root Entity
	 * @param query {@code CriteriaQuery} you use
	 */
	private void findByColor(Root<Commodity> root, CriteriaQuery<?> query){
		if(!filter.getColorId().isEmpty()){
			predicates.add(root.get("color").in(filter.getColorId()));
		}
	}

	/**
	 * This method gets {@code Subcategory}'s specified by client
	 * and adds them to this {@code Predicate} object
	 * @param root root Entity
	 * @param query {@code CriteriaQuery} you use
	 */
	private void findBySubcategory(Root<Commodity> root, CriteriaQuery<?> query){
		if(!filter.getSubcategoryId().isEmpty()){
			predicates.add(root.get("subcategory").in(filter.getSubcategoryId()));
		}
	}

	/**
	 * This method gets {@code Category}'s specified by client
	 * and adds them to this {@code Predicate} object
	 * @param root root Entity
	 * @param query {@code CriteriaQuery} you use
	 */
	private void findByCategory(Root<Commodity> root, CriteriaQuery<?> query){
		if(!filter.getCategoryId().isEmpty()){
			predicates.add(root.get("color").in(filter.getCategoryId()));
		}
	}

	/**
	 * This method gets {@code Fabricator}'s specified by client
	 * and adds them to this {@code Predicate} object
	 * @param root root Entity
	 * @param query {@code CriteriaQuery} you use
	 */
	private void findByFabricator(Root<Commodity> root, CriteriaQuery<?> query){
		if(!filter.getFabricatorId().isEmpty()){
			predicates.add(root.get("color").in(filter.getFabricatorId()));
		}
	}

	/**
	 * This method fetches related Entities you need
	 * @param root root Entity
	 * @param query {@code CriteriaQuery} you use
	 */
	private void fetch(Root<Commodity> root, CriteriaQuery<?> query){
		if(!query.getResultType().equals(Long.class)){
			query.distinct(true);
			root.fetch("country");
			root.fetch("color");
			root.fetch("category");
			root.fetch("subcategory");
			root.fetch("fabricator");
		}
	}

	/**
	 * This method builds and returns {@code Predicate} object
	 * @param root root Entity
	 * @param query {@code CriteriaQuery} you use
	 * @param cb {@code CriteriaBuilder} you use
	 * @return built {@code Predicate} object
	 */
	@Override
	public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		fetch(root, query);
		findByName(root, query, cb);
		findByPrice(root, query, cb);
		findByCountry(root, query);
		findByColor(root, query);
		findBySubcategory(root, query);
		findByCategory(root, query);
		findByFabricator(root, query);
		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

}
