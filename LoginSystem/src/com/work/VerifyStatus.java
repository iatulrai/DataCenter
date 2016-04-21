package com.work;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyStatus extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1540503876002876755L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String scode = req.getParameter("scode");
		String msg = com.db.Admin.verifyStatus(userid, scode);
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}