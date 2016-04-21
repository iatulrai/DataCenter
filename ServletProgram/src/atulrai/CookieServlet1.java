package atulrai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet1
 */

public class CookieServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String n = request.getParameter("userName");
			out.print("Welcome " + n);

			Cookie ck = new Cookie("uname", n); // create cookie object
			response.addCookie(ck); // adding cookie in the response

			// creating submit button
			out.print("<form action='servletcookie2'>");
			out.print("<input type='submit' value='go'>");
			out.print("</form>");

			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
