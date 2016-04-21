package com.mytag;

import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyDate extends TagSupport {
	private static final long serialVersionUID = -7322371710038634091L;

	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut(); // get the jsp writer for
													// write on jsp page
			Calendar c = Calendar.getInstance();
			out.println(c.get(c.DATE) + " / " + (c.get(c.MONTH) + 1) + " / " + c.get(c.YEAR));

		} catch (Exception e) {
			e.toString();
		}
		return 0;// 0 for false : means not call the remain tag body
		// return 1 ; // 1 for true : means call the remain tag body
	}

}
