package com.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class Admin {

	public static Connection connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/agile", "root", "");
	}

	public static String addStudent(String name, String marks, String sem, String college, String mobile) {
		try {
			CallableStatement cs = connect().prepareCall("{call addUpdStudent(?,?,?,?,?,?,?,?)}");

			cs.setString(1, "I");
			cs.setString(2, "0");
			cs.setString(3, name);
			cs.setString(4, marks);
			cs.setString(5, sem);
			cs.setString(6, college);
			cs.setString(7, mobile);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.execute();
			return cs.getString(8);

		} catch (Exception e) {
			return e.toString();
			// TODO: handle exception
		}
	}
	
	public static ResultSet getStudent() throws Exception{
		
		return connect().prepareCall("{call getStudent()}").executeQuery();
	}

}
