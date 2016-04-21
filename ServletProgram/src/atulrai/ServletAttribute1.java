package atulrai;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAttribute1 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7036095930423000592L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {

			res.setContentType("text/html");
			PrintWriter out = res.getWriter();

			ServletContext context = getServletContext();
			String n = (String) context.getAttribute("company");

			out.println("Welcome to " + n);
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}