package com.march8;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelEmp extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String empno = req.getParameter("n");
		String msg = com.db.Admin.delEmp(empno);
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("List").forward(req, res);
	}
}