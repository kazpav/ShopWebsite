package ua.website.util;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import ua.website.dto.filter.SimpleFilter;

/**
 * This class builds links for pagination and filtering objects
 * on the web page
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.dto.filter.SimpleFilter
 */
public interface ParamBuilder {

	/**
	 * Builds links with pagination and sorting, without filtering strategy
	 * @param pageable pagination settings
	 * @return build link
	 */
	public static String getParams(Pageable pageable){
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
				buffer.append(",desc");
			});
		}
		return buffer.toString();
	}

	/**
	 * Builds links with pagination, sorting and filtering
	 * @param pageable pagination settings
	 * @param filter filtering settings
	 * @return build link
	 */
	public static String getParams(Pageable pageable, SimpleFilter filter){
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
				buffer.append(",desc");
			});
		}
		if(!filter.getSearch().isEmpty()){
			buffer.append("&search=");
			buffer.append(filter.getSearch());
		}
		return buffer.toString();
	}
}