package com.work;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelUser extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -664955165090587172L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String u = req.getParameter("u");
		String msg = com.db.Admin.delUser(u);
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("Wel.jsp").forward(req, resp);
	}

}