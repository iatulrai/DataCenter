package com.work;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveStudent
 */
public class SaveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String marks = req.getParameter("marks");
		String sem = req.getParameter("sem");
		String college = req.getParameter("college");
		String mobile = req.getParameter("mobile");

		String msg = com.db.Admin.addStudent(name, marks, sem, college, mobile);

		req.setAttribute("msg", msg);

	}
}
