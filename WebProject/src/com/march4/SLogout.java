package com.march4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession ses = request.getSession(true);

		String u = (String) ses.getAttribute("id");

		if (u == null) {

			response.sendRedirect("SLogin?t=1");
		} else {

			ses.invalidate();

			PrintWriter out = response.getWriter();
			out.println("<body bgcolor=lightgreen><h2><tt>Hello " + u + " You are successfully logedin");
			out.println("<hr size=3 color=navy><a href=SLogin.jsp>Click here for Login</a>");
			response.setHeader("Cache-Control", "no-cache");

		}

	}

}
