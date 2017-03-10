package ua.website.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.website.dto.filter.SubcategoryFilter;
import ua.website.entity.Subcategory;

public class SubcategorySpecification implements Specification<Subcategory> {

	private final SubcategoryFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	public SubcategorySpecification(SubcategoryFilter filter) {
		this.filter = filter;
	}
	
	private void findByName(Root<Subcategory> root, CriteriaQuery<?> query,CriteriaBuilder cb) {
		if (!filter.getSearch().isEmpty()) {
			predicates.add(cb.like(root.get("name"), filter.getSearch()+"%"));
		}
	}

	private void findByCategory(Root<Subcategory> root, CriteriaQuery<?> query) {
		if (!filter.getCategoryId().isEmpty()) {
			predicates.add(root.get("category").in(filter.getCategoryId()));
		}
	}

	private void fetch(Root<Subcategory> root, CriteriaQuery<?> query) {
		if (!query.getResultType().equals(Long.class)) {
			query.distinct(true);
			root.fetch("category");
		}
	}

	@Override
	public Predicate toPredicate(Root<Subcategory> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root, query);
		findByName(root, query, cb);
		findByCategory(root, query);
		if (predicates.isEmpty())
			return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

}
