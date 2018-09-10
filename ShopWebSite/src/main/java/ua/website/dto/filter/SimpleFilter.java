package ua.website.dto.filter;

/**
 * Data transfer object that you need for filtering Entities on web page
 * Used for forms with text input to find Entities by names
 * @author Pavel Kazarin
 * @version 1.0
 */
public class SimpleFilter {

	/** Entity's name the client is looking for */
	private String search = "";

	/**
	 * Getter for {@code SimpleFilter}'s search
	 * @return this {@code SimpleFilter}'s search
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * Setter for {@code SimlpleFilter}'s search,
	 * changes this {@code SimlpleFilter}'s search
	 * @param search this {@code SimlpleFilter}'s new search
	 */
	public void setSearch(String search) {
		this.search = search;
	}
	
}
