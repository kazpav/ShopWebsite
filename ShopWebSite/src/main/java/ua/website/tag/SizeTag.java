package ua.website.tag;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * This class builds size tags
 * @author Pavel Kazarin
 * @version 1.0
 */
public class SizeTag extends SimpleTagSupport {

	/** {@code StringWriter} that will be used during tag building */
	private final StringWriter sw = new StringWriter();

	/** Constant for '&' symbol*/
	private final static String AMPER = "&";

	/** Constant for '?' symbol*/
	private final static String QUEST = "?";

	/** Constant for '=' symbol*/
	private final static String EQUAL = "=";

	/** Title */
	private String title = "Size";

	/** Size */
	private int size;

	/** Possible Sizes */
	private int[] posibleSizes;

	/** Tag builder */
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		sw.append("<div class='dropdown'><button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'>");
		sw.append(title);
		sw.append("<span class='caret'></span></button>");
		sw.append("<ul class='dropdown-menu'>");
		for(int size : posibleSizes){
			if(size == this.size){
				sw.append("<li class='active'>");
			}else{
				sw.append("<li>");
			}
			sw.append("<a href='");
			sw.append(QUEST);
			sw.append("size=");
			sw.append(String.valueOf(size));
			addAllParameters();
			sw.append("'>");
			sw.append(String.valueOf(size));
			sw.append("</a></li>");
		}
		sw.append("</ul>");
		sw.append("</div>");
		out.println(sw.toString());
	}

	/** Adds all parameters */
	private void addAllParameters(){
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		Map<String, String[]> map = request.getParameterMap();
		for(Entry<String, String[]> entry : map.entrySet()){
			for(String value : entry.getValue()){
				if(!entry.getKey().equals("size")){
					sw.append(AMPER);
					sw.append(entry.getKey());
					sw.append(EQUAL);
					sw.append(value);
				}
			}
		}
	}

	/** Sets size */
	public void setSize(int size) {
		this.size = size;
	}

	/** Sets posible sizes */
	public void setPosibleSizes(String posibleSizes){
		StringTokenizer tokenizer = new StringTokenizer(posibleSizes, ", ");
		this.posibleSizes = new int[tokenizer.countTokens()];
		int i = 0;
		while(tokenizer.hasMoreTokens()){
			this.posibleSizes[i] = Integer.valueOf(tokenizer.nextToken());
			i++;
		}
	}

	/** Sets titile */
	public void setTitle(String title){
		this.title = title;
	}
}