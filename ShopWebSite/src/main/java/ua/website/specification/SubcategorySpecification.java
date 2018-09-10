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

/**
 * Specification class that uses Spring Framework's Specification interface
 * for making requests to DataBase and sending back results,
 * during filtering {@code Subcategory} entities on web page
 * using {@code SubcategoryFilter} data transfer objects
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.entity.Subcategory
 * @see ua.website.dto.filter.SubcategoryFilter
 * @see ua.website.controller.admin.SubcategoryController
 * @see ua.website.dao.SubcategoryDao
 */
public class SubcategorySpecification implements Specification<Subcategory> {

	/** {@code SubcategoryFilter} object that comes from input form */
	private final SubcategoryFilter filter;

	/** List of {@code Predicate}'s */
	private final List<Predicate> predicates = new ArrayList<>();

	/**
	 * Constructor that sets {@code SubcategoryFilter} object
	 * @param filter {@code SubcategoryFilter} object that came in input
	 */
	public SubcategorySpecification(SubcategoryFilter filter) {
		this.filter = filter;
	}

	/**
	 * This method gets name specified by client
	 * and adds it to this {@code Predicate} object
	 * @param root root Entity
	 * @param query {@code CriteriaQuery} you use
	 * @param cb {@code CriteriaBuilder} you use
	 */
	private void findByName(Root<Subcategory> root, CriteriaQuery<?> query,CriteriaBuilder cb) {
		if (!filter.getSearch().isEmpty()) {
			predicates.add(cb.like(root.get("name"), filter.getSearch()+"%"));
		}
	}

	/**
	 * This method gets {@code Category}'s specified by client
	 * and adds them to this {@code Predicate} object
	 * @param root root Entity
	 * @param query {@code CriteriaQuery} you use
	 */
	private void findByCategory(Root<Subcategory> root, CriteriaQuery<?> query) {
		if (!filter.getCategoryId().isEmpty()) {
			predicates.add(root.get("category").in(filter.getCategoryId()));
		}
	}

	/**
	 * This method fetches related Entities you need
	 * @param root root Entity
	 * @param query {@code CriteriaQuery} you use
	 */
	private void fetch(Root<Subcategory> root, CriteriaQuery<?> query) {
		if (!query.getResultType().equals(Long.class)) {
			query.distinct(true);
			root.fetch("category");
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
