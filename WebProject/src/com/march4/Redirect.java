package com.march4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String u = request.getParameter("uid");
		String p = request.getParameter("pass");

		if (u == null) {

			response.sendRedirect("redirect.jsp?t=1"); // 1 for direct open ke
														// liye

		} else if (u.equals("")) { // if id and pass is blank

			response.sendRedirect("redirect.jsp?t=2");

		} else if (p.equals("atul")) {

			request.setAttribute("id", u);
			response.sendRedirect("Welcome");
		} else {
			response.sendRedirect("redirect.jsp?t=0"); // 0 for invalid
		}

	}

}
