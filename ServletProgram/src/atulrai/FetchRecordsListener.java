// Improving Servlet performance to fetch records from database

package atulrai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class FetchRecordsListener
 *
 */
@WebListener
public class FetchRecordsListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent e) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:oracle12c", "AtulRai",
					"atulrai");

			PreparedStatement ps = con.prepareStatement("select * from csuser");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				FetchRecordsUser u = new FetchRecordsUser();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				list.add(u);
			}

			con.close();

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}

		// storing the ArrayList object in servlet context
		ServletContext context = e.getServletContext();
		context.setAttribute("data", list);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Project Undeployed...");

	}

}
