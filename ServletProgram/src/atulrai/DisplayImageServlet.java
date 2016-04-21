//Example to display image using Servlet

package atulrai;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayImageServlet
 */
@WebServlet("/DisplayImageServlet")
public class DisplayImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();

		FileInputStream fin = new FileInputStream(
				"D:\\Work-Study\\images\\atulrai.jpg");
		
		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		
		int ch = 0;
		
		while((ch=bin.read()) != -1){
			bout.write(ch);
		}
		
		bin.close();
		fin.close();
		bout.close();
		out.close();
	}
}
