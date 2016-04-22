package com.march8;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ename = request.getParameter("ename");
		String sal = request.getParameter("sal");
		String deptno = request.getParameter("deptno");
		String mobile = request.getParameter("mobile");
		String msg = com.db.Admin.addEmp(ename, sal, deptno, mobile);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("Emp.jsp").forward(request, response);
	}
}
