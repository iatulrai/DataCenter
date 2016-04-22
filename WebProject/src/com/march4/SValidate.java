package com.march4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String u = request.getParameter("uid");
		String p = request.getParameter("pass");

		if (u == null) {

			response.sendRedirect("SLogin.jsp?t=1");

		} else if (u.equals("")) {

			response.sendRedirect("SLogin.jsp?t=2");

		} else if (p.equals("atul")) {

			HttpSession ses = request.getSession(true);
			ses.setAttribute("id", u);
			response.sendRedirect("SWelcome");

		} else {

			response.sendRedirect("SLogin.jsp?t=0");
		}
	}

}
