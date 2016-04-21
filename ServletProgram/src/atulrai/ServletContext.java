package atulrai;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext
 */
@WebServlet("/ServletContext")
public class ServletContext extends HttpServlet {
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

		javax.servlet.ServletContext context = getServletContext(); // creating ServletContext object
														
		//Getting the value of the initialization parameter and printing it  
		String driverName = context.getInitParameter("dname");
		out.println("<b>Driver name is : </b>" + driverName);
		out.close();
	}

	public List getAttribute(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
