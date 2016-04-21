package com.mytag;

import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTime extends TagSupport {

	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();

			Calendar c = Calendar.getInstance();
			out.println(c.get(c.HOUR_OF_DAY) + " : " + c.get(c.MINUTE) + " : " + c.get(c.SECOND));

		} catch (Exception e) {
			// TODO: handle exception
			e.toString();
		}
		return 0;
	}

}
