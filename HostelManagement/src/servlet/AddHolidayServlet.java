package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

@WebServlet(urlPatterns = "/admin/addholiday")
public class AddHolidayServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String year = request.getParameter("year");
		String month = request.getParameter("month");
		int challan = Integer.parseInt(request.getParameter("challan"));
		int holiday = Integer.parseInt(request.getParameter("holiday"));

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		UserDAO userDao = new UserDAO();
		userDao.addHoliday(challan, year, month, holiday);

		response.setContentType("text/html");

		out.println("Holiday Added");

	}

}
