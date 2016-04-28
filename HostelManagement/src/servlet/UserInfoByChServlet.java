package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dto.UserDTO;

@WebServlet(urlPatterns = "/admin/userInfoByCh")
public class UserInfoByChServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		int challan = Integer.parseInt(request.getParameter("challan"));

		UserDAO userDao = new UserDAO();
		UserDTO userDTO = userDao.getUserInfoByCh(challan);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body><table>");
		out.println("<tr><td>Challan Number: " + userDTO.getChallan()
				+ "</td></tr>");
		out.println("<tr><td>Name: " + userDTO.getName() + "</td></tr>");
		out.println("<tr><td>Father Name: " + userDTO.getFname() + "</td></tr>");
		out.println("<tr><td><a href='addholiday.jsp?challan="
				+ userDTO.getChallan() + "'> Add Holiday</a></td></tr>");
		out.println("</table></body></html>");
	}

}
