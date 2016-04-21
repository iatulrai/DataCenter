package com.work;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Validate extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5503164828492761458L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		String msg = com.db.Admin.checkId(userid, pass);
		if (msg.startsWith("Sorry")) {
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else {
			String ar[] = msg.split(":"); // ADMIN:Y/N , USER:Y/N , ar[0]=USER ,
											// ar[1] = Y/N
			if (ar[1].equals("Y")) {
				HttpSession ses = req.getSession(true);
				ses.setAttribute("id", userid);
				ses.setAttribute("mode", ar[0]);
				resp.sendRedirect("Wel.jsp");
			} else {
				req.setAttribute("msg", "Hello " + userid + ", Plz enter ur Security code from ur mail id");
				req.setAttribute("id", userid);
				req.getRequestDispatcher("Verify.jsp").forward(req, resp);
			}
		}
	}
}