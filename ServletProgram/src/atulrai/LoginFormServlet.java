package atulrai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginFormServlet
 */

public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String n = request.getParameter("username");
		String p = request.getParameter("userpass");

		if (LoginFormDAO.validate(n, p)) {

			RequestDispatcher rd = request.getRequestDispatcher("login2url");
			rd.forward(request, response);

		} else {
			out.print("Wrong username or password");

			RequestDispatcher rd = request
					.getRequestDispatcher("login-form-index.html");

			rd.include(request, response);
		}

		out.close();
	}

}
