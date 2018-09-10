package ua.website.tag;


import static java.lang.String.valueOf;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Map.Entry;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.data.domain.Page;

/**
 * This class builds Pageable tags
 */
public class PageableTag extends SimpleTagSupport{

	/** Constant for first page */
	private final static int FIRST = 1;

	/** Constant for quantity of visible pages */
	private final static int VISIBLE = 5;

	/** Constant for '&' symbol*/
	private final static String AMPER = "&";

	/** Constant for '?' symbol*/
	private final static String QUEST = "?";

	/** Constant for '=' symbol*/
	private final static String EQUAL = "=";

	/** {@code StringWirter} object for tag building */
	private final StringWriter sw = new StringWriter();

	/** Last page */
	private int last;

	/** Current page */
	private int current;

	/** Pagination size */
	private int size;

	/** Tag for building */
	private String stContainer = "<tr>";

	/** Tag for building */
	private String endContainer = "</tr>";

	/** Tag for building */
	private String stCell = "<td>";

	/** Tag for building */
	private String endCell = "</td>";

	/** Tag for building */
	private String activeClass = "active";

	/** Tag builder */
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		sw.append(stContainer);
		buildFirstPage();
		buildLeftArrow();
		if(last<=VISIBLE){
			for (int i = 1; i <= last; i++) {
				buildOneCell(i);
			}
		}else{
			int start = (current-VISIBLE/2) >= FIRST ? (current-VISIBLE/2) : FIRST;
			int finish = (current+VISIBLE/2) <= last ? (current+VISIBLE/2) : last;
			start = (finish - start < VISIBLE) ? (finish - VISIBLE + 1) : start;
			start = start <= 0 ? FIRST : start;
			finish = (finish - start) < VISIBLE ? start + VISIBLE - 1 : finish;
			finish = finish > last ? last : finish;
			for (; start <= finish; start++) {
				buildOneCell(start);
			}
		}
		buildRightArrow();
		buildLastPage();
		sw.append(endContainer);
		out.println(sw.toString());
	}

	/** Last page builder */
	private void buildLastPage(){
		sw.append(stCell);
		sw.append("<a href='");
		sw.append(QUEST);
		sw.append("page=");
		sw.append(valueOf(last));
		sw.append(AMPER);
		sw.append("size=");
		sw.append(valueOf(size));
		addAllParameters();
		sw.append("'>");
		sw.append(">>");
		sw.append("</a>");
		sw.append(endCell);
	}

	/** First page builder*/
	private void buildFirstPage(){
		sw.append(stCell);
		sw.append("<a href='");
		sw.append(QUEST);
		sw.append("page=");
		sw.append(valueOf(FIRST));
		sw.append(AMPER);
		sw.append("size=");
		sw.append(valueOf(size));
		addAllParameters();
		sw.append("'>");
		sw.append("<<");
		sw.append("</a>");
		sw.append(endCell);
	}

	/** Right arrow builder */
	private void buildRightArrow(){
		sw.append(stCell);
		sw.append("<a href='");
		sw.append(QUEST);
		sw.append("page=");
		if(current == last) sw.append(valueOf(current));
		else sw.append(valueOf(current+1));
		sw.append(AMPER);
		sw.append("size=");
		sw.append(valueOf(size));
		addAllParameters();
		sw.append("'>");
		sw.append(">");
		sw.append("</a>");
		sw.append(endCell);
	}

	/** Left arrow builder */
	private void buildLeftArrow(){
		sw.append(stCell);
		sw.append("<a href='");
		sw.append(QUEST);
		sw.append("page=");
		if(current == FIRST) sw.append(valueOf(current));
		else sw.append(valueOf(current-1));
		sw.append(AMPER);
		sw.append("size=");
		sw.append(valueOf(size));
		addAllParameters();
		sw.append("'>");
		sw.append("<");
		sw.append("</a>");
		sw.append(endCell);
	}

	/** One cell builder*/
	private void buildOneCell(int number){
		if(number == current){
			sw.append(stCell.substring(0, stCell.length()-1));
			sw.append(" class='");
			sw.append(activeClass);
			sw.append("'>");
		}else{
			sw.append(stCell);
		}
		sw.append("<a href='");
		sw.append(QUEST);
		sw.append("page=");
		sw.append(valueOf(number));
		sw.append(AMPER);
		sw.append("size=");
		sw.append(valueOf(size));
		addAllParameters();
		sw.append("'>");
		sw.append(valueOf(number));
		sw.append("</a>");
		sw.append(endCell);
	}

	/** Adding all parameters */
	private void addAllParameters(){
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		Map<String, String[]> map = request.getParameterMap();
		for(Entry<String, String[]> entry : map.entrySet()){
			for(String value : entry.getValue()){
				if(!(entry.getKey().equals("page")||entry.getKey().equals("size"))){
					sw.append(AMPER);
					sw.append(entry.getKey());
					sw.append(EQUAL);
					sw.append(value);
				}
			}
		}
	}

	/** Sets page */
	public void setPage(Page<?> page) {
		if(page==null) throw new IllegalArgumentException("Rename all findAll() attributes in Controller to page");
		last = page.getTotalPages();
		current = page.getNumber()+1;
		size = page.getSize();
	}

	/** Sets container*/
	public void setContainer(String container){
		stContainer = container.substring(0, container.indexOf("<", 1));
		endContainer = container.substring(container.indexOf("<", 1));
	}

	/** Sets cell */
	public void setCell(String cell){
		stCell = cell.substring(0, cell.indexOf("<", 1));
		endCell = cell.substring(cell.indexOf("<", 1));
	}
}