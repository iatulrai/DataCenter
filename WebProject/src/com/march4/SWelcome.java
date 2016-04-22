package com.march4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SWelcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession ses = request.getSession(true);

		String u = (String) ses.getAttribute("id");

		if (u == null) {
			response.sendRedirect("SLogin.jsp?t=1");
		} else {

			PrintWriter out = response.getWriter();
			out.println("<body bgcolor=lightgreen><h2><tt>Hello " + u + " Welcomes you!");
			out.println("Click Here");
		}

	}

}
