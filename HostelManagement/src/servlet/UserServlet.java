package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

@WebServlet(urlPatterns = "/admin/userservlet", loadOnStartup = 1)
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		int challan = Integer.parseInt(request.getParameter("challan"));
		String name = request.getParameter("name");
		String fname = request.getParameter("f_name");
		String dob = request.getParameter("dob");
		String mob = request.getParameter("mob");
		String fmob = request.getParameter("f_mob");
		String add = request.getParameter("address");
		String course = request.getParameter("course");
		String sem = request.getParameter("sem");
		String email = request.getParameter("email");
		String doe = request.getParameter("doe");

		UserDAO userDao = new UserDAO();
		userDao.saveUser(challan, name, fname, dob, mob, fmob, add, course,
				sem, email, doe);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>New Student User Registration Form- RSMT BOY'S HOSTEL</title>");
		out.println("<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/css/userform.css' />");
		out.println("</head><body>");
		out.println("<h1>RSMT BOY'S HOSTEL</h1>");
		out.println("User Info submitted.");
		out.println("</body></html>");
	}
}