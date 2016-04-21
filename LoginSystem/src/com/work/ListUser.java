package com.work;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListUser extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6265944787051126229L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses = req.getSession(true);
		String u = (String) ses.getAttribute("id");
		String m = (String) ses.getAttribute("mode");
		PrintWriter out = resp.getWriter();
		out.println("<body bgcolor=lightyellow><tt><table border=1 width=95%><tr>");
		try {
			ResultSet rs = com.db.Admin.listUsers();
			ResultSetMetaData mt = rs.getMetaData();
			for (int i = 1; i <= mt.getColumnCount(); i++)
				out.print("<th>" + mt.getColumnName(i));
			out.println("<th>Action");
			while (rs.next()) {
				out.println("<tr>");
				for (int i = 1; i <= mt.getColumnCount(); i++) {
					if (i == 2) {
						if (m.equals("USER"))
							out.print("<td>" + com.db.Admin.encpt(rs.getString(2).length()));
						else
							out.print("<td>" + rs.getString(2));
					} else
						out.print("<td>" + rs.getString(i));
				}
				if (m.equals("USER")) // for last column - for action
					out.print("<td><u>Delete</u>");
				else {
					if (rs.getString(3).equals("ADMIN"))
						out.print("<td><u>Delete</u>");
					else
						out.print("<td><a href=DelUser?u=" + rs.getString(1) + ">Delete</a>");
				}
			}
			out.println("</table>");
			String msg = (String) req.getAttribute("msg");
			if (msg != null)
				out.print(msg);
		} catch (Exception ex) {
			out.println(ex.toString());
		}

	}

}