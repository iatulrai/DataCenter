//Example of ServletContext to get all the initialization parameters
package atulrai;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext1
 */
@WebServlet("/ServletContext1")
public class ServletContext1 extends HttpServlet {
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

		ServletContext context = getServletContext();

		Enumeration<String> e = context.getInitParameterNames();

		String str = "";
		while (e.hasMoreElements()) {
			str = e.nextElement();
			out.print("<br> " + context.getInitParameter(str));
		}
	}

}
