package com.mytag;

import java.sql.ResultSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyState extends TagSupport {

	public int doStartTag() throws JspException {
		try {
			ResultSet rs = com.db.Admin.getState();
			JspWriter out = pageContext.getOut();
			out.println("<option value= ''>Select state</option>");
			while (rs.next()) {
				out.println("<option value='" + rs.getString(1) + "'>" + rs.getString(1) + "</option>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.toString();
		}
		return 0;
	}

}
