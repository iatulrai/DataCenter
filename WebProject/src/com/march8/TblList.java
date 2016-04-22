package com.march8;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TblList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<body><tt><table border=1 width=90%><tr>");
		try {
			ResultSet rs = com.db.Admin.getData();
			ResultSetMetaData mt = rs.getMetaData();
			int NOC = mt.getColumnCount();
			for (int i = 1; i <= NOC; i++)
				out.print("<th>" + mt.getColumnName(i));
			out.println("<th>Action");
			while (rs.next()) {
				
				out.println("<tr>");
				for (int i = 1; i <= NOC; i++)
					out.print("<td>" + rs.getString(i));
				out.println("<td><a href=DelEmp?n=" + rs.getString(1) + ">Delete</a> | <a href=Update.jsp?n="
						+ rs.getString(1) + ">Update</a>");
				out.println("</tr>");
			}
			out.println("</table>");
			String m = (String) req.getAttribute("msg");
			if (m != null)
				out.println(m);
			out.println("<hr size=4 color=red><a href=Emp.jsp>Add New Employee</>");

		} catch (Exception ex) {
			out.println(ex.toString());
		}
	}

}