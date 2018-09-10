package ua.website.tag;


import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * This class builds allParams tags
 * @author Pavel Kazarin
 * @version 1.0
 */
public class AllParams extends SimpleTagSupport{

	/**{@StringWirter} object for tab built */
	private final StringWriter sw = new StringWriter();

	/** Constant for '&' symbol */
	private final static String AMPER = "&";

	/** Constant for '?' symbol */
	private final static String QUEST = "?";

	/** Constant for '=' symbol */
	private final static String EQUAL = "=";

	/** Tag builder */
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		Map<String, String[]> map = request.getParameterMap();
		boolean isFirst = true;
		for(Entry<String, String[]> entry : map.entrySet()){
			for(String value : entry.getValue()){
				if(isFirst){
					sw.append(QUEST);
					isFirst = false;
				}else{
					sw.append(AMPER);
				}
				sw.append(entry.getKey());
				sw.append(EQUAL);
				sw.append(value);
			}
		}
		out.println(sw.toString());
	}
}