// Improving Servlet performance to fetch records from database

package atulrai;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchRecordsServlet2
 */
@WebServlet("/FetchRecordsServlet2")
public class FetchRecordsServlet2 extends HttpServlet {
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

		long before = System.currentTimeMillis();

		ServletContext context = getServletContext();
		List list = (List) context.getAttribute("data");

		Iterator itr = list.iterator();
		while (itr.hasNext()) {

			FetchRecordsUser u = (FetchRecordsUser) itr.next();
			out.print("<br>" + u.getId() + " " + u.getName() + " "
					+ u.getPassword());
		}

		long after = System.currentTimeMillis();
		out.print("<br>total time :" + (after - before));

		out.close();
	}

}