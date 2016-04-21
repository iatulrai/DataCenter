package atulrai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginFormDAO {

	public static boolean validate(String name, String pass) {
		boolean status = false;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:oracle12c", "AtulRai",
					"atulrai");

			PreparedStatement ps = con
					.prepareStatement("select * from login where name=? and pass=?");

			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;

	}
}
