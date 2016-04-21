package com.mytag;

import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyJspTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut(); // return the intance of jsp
												// writer

		try {

			out.print(Calendar.getInstance().getTime()); // print the date and
															// time
		} catch (Exception e) {
			e.toString();
		}
		return SKIP_BODY; // will not evaluate the body content of the tag
	}

}
