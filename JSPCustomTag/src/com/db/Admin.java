package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Admin {

	public static Connection connect() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://127.0.01:3306/test", "root", "");

	}

	public static ResultSet getState() throws Exception {
		return connect().prepareCall("{call getState()}").executeQuery();
	}

}
