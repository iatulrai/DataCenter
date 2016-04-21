package atulrai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HFFServlet1
 */
@WebServlet("/HFFServlet1")
public class HFFServlet1 extends HttpServlet {
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

			// creating form tha have hidden textfield

			out.print("<form action='HFFServlet2'>");
			out.print("<input type= 'hidden' name= 'uname' value= '" + n + "'>");
			out.print("<input type='submit' value='go'>");
			out.print("</form>");
			out.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
