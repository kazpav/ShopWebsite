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

public class CommoditySpecification implements Specification<Commodity>{
	private final CommodityFilter filter;
	
	private final List<Predicate> predicates = new ArrayList<>();
	
	private static final Pattern REG = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");

	

	public CommoditySpecification(CommodityFilter filter) {
		this.filter = filter;
		if(REG.matcher(filter.getMax()).matches()){
			filter.setMaxPrice(new BigDecimal(filter.getMax().replace(',', '.')));
		}
		if(REG.matcher(filter.getMax()).matches()){
			filter.setMinPrice(new BigDecimal(filter.getMin().replace(',', '.')));
		}
	}
	
	private void findByName(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getNameSearch().isEmpty()){
			predicates.add(cb.like(root.get("name"), filter.getNameSearch()+"%"));
		}
	}
	
	private void findByPrice(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(filter.getMaxPrice()!=null){
			predicates.add(cb.le(root.get("price"), filter.getMaxPrice()));
		}
		if(filter.getMinPrice()!=null){
			predicates.add(cb.ge(root.get("price"), filter.getMinPrice()));
		}
	}
	
	private void findByCountry(Root<Commodity> root, CriteriaQuery<?> query){
		if(!filter.getCountryId().isEmpty()){
			predicates.add(root.get("country").in(filter.getCountryId()));
		}
	}
	private void findByColor(Root<Commodity> root, CriteriaQuery<?> query){
		if(!filter.getColorId().isEmpty()){
			predicates.add(root.get("color").in(filter.getColorId()));
		}
	}
	private void findBySubcategory(Root<Commodity> root, CriteriaQuery<?> query){
		if(!filter.getSubcategoryId().isEmpty()){
			predicates.add(root.get("subcategory").in(filter.getSubcategoryId()));
		}
	}
	private void findByCategory(Root<Commodity> root, CriteriaQuery<?> query){
		if(!filter.getCategoryId().isEmpty()){
			predicates.add(root.get("color").in(filter.getCategoryId()));
		}
	}
	private void findByFabricator(Root<Commodity> root, CriteriaQuery<?> query){
		if(!filter.getFabricatorId().isEmpty()){
			predicates.add(root.get("color").in(filter.getFabricatorId()));
		}
	}
	
	private void fetch(Root<Commodity> root, CriteriaQuery<?> query){
		//Long.class on github !
		if(!query.getResultType().equals(Long.class)){
			query.distinct(true);
			root.fetch("country");
			root.fetch("color");
			root.fetch("category");
			root.fetch("subcategory");
			root.fetch("fabricator");
		}
	}

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
