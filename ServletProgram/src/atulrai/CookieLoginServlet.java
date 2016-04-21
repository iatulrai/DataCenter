package atulrai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieLoginServlet
 */
@WebServlet("/CookieLoginServlet")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("cookie-link.html").include(request,
				response);

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (password.equals("cookie")) {
			out.print("You are successfully logged in :)");
			out.print("<br>Welcome " + name);

			Cookie ck = new Cookie("name", name);
			response.addCookie(ck);

		} else {
			out.print("Sorry ! user name or password error");
			request.getRequestDispatcher("cookie-login.html").include(request,
					response);

		}

		out.close();
	}

}
