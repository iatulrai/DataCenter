package atulrai;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"AtulRai", "atulrai");

			// storing connection object as an attribute in ServletContext

			ServletContext ctx = event.getServletContext();
			ctx.setAttribute("mycon", con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

}
