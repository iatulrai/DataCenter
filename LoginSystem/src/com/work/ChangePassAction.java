package com.work;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePassAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2578972932105254476L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		String np = req.getParameter("np");
		HttpSession ses = req.getSession(true);
		String userid = (String) ses.getAttribute("id");
		String msg = com.db.Admin.changePass(userid, op, np);
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("ChangePass.jsp").forward(req, resp);
	}

}