package atulrai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HttpSessionProfileServlet
 */
@WebServlet("/HttpSessionProfileServlet")
public class HttpSessionProfileServlet extends HttpServlet {
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
		request.getRequestDispatcher("http-session-login-logout-link.html")
				.include(request, response);

		HttpSession session = request.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("name");

			out.print("Hello, " + name + " Welcome to Profile");
		} else {
			out.print("Please login first");
			request.getRequestDispatcher("http-session-login-logout-login.html")
					.include(request, response);
		}
		out.close();
	}
}
