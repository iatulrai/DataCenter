package com.db;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class Admin {
	public static Connection connect() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		return (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/struts29", "root", "");
	}

	public static String addemp(String ename, String photo) {
		try {
			CallableStatement cs = connect().prepareCall("{call addEmp(?,?,?)}");

			cs.setString(1, ename);
			FileInputStream r = new FileInputStream(photo);
			cs.setBinaryStream(2, r);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.execute();
			return cs.getString(3);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static ResultSet getData() throws Exception {
		return connect().prepareCall("{call getData()}").executeQuery();
	}

	public static ResultSet getPhoto(String empno) throws Exception {
		CallableStatement cs = connect().prepareCall("{call getPhoto(?)}");
		cs.setString(1, empno);
		return cs.executeQuery();
	}

}
