package atulrai;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchData
 */
@WebServlet("/FetchData")
public class FetchData extends HttpServlet {
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
		try {
			// retreving connection object from servletcontext object
			ServletContext ctx = getServletContext();
			Connection con = (Connection) ctx.getAttribute("mycon");

			// retieving data from table mydata
			PreparedStatement ps = con
					.prepareStatement("select * from MYDATA",
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				out.print("<br>" + rs.getString(1)+ " " + rs.getString(2));
			}
			
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		out.close();
	}

}
