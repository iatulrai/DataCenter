package atulrai;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurrentTime extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4993687840694123447L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		PrintWriter out = res.getWriter();

		Date date = new Date();
		DateFormat df = DateFormat.getInstance();

		String zone = req.getParameter("zone");
		if (zone != null) {
			TimeZone tz = TimeZone.getTimeZone(zone);
			df.setTimeZone(tz);
		}

		out.println(df.format(date));
	}
}