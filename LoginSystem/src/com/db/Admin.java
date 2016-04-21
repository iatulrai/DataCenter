package com.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class Admin {

	public static Connection connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/loginsystem", "root", "");

	}

	public static String addUser(String userid, String pass, int scode, String mailid) {
		try {
			CallableStatement cs = connect().prepareCall("{call addUser(?,?,?,?,?)}");
			cs.setString(1, userid); // set the 1st ? value
			cs.setString(2, pass); // 2nd ? value
			cs.setInt(3, scode); // 3rd ? value
			cs.setString(4, mailid); // 4th ? value
			cs.registerOutParameter(5, Types.VARCHAR); // register 5th parameter
														// as varchar for return
														// value
			cs.execute(); // procedure execute
			return cs.getString(5); // return out parameter value
		} catch (Exception ex) {
			return ex.toString();
		}
	}

	public static String checkId(String userid, String pass) {
		try {
			CallableStatement cs = connect().prepareCall("{call checkId(?,?,?)}");
			cs.setString(1, userid);
			cs.setString(2, pass);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.execute();
			return cs.getString(3);
		} catch (Exception ex) {
			return ex.toString();
		}
	}

	public static String changePass(String userid, String op, String np) {
		try {
			CallableStatement cs = connect().prepareCall("{call changePass(?,?,?,?)}");
			cs.setString(1, userid);
			cs.setString(2, op);
			cs.setString(3, np);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.execute();
			return cs.getString(4);
		} catch (Exception ex) {
			return ex.toString();
		}
	}

	public static String forget(String userid) {
		try {
			CallableStatement cs = connect().prepareCall("{call forget(?,?)}");
			cs.setString(1, userid);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			return cs.getString(2);
		} catch (Exception ex) {
			return "Sorry - " + ex;
		}
	}

	public static String verifyStatus(String userid, String scode) {
		try {
			CallableStatement cs = connect().prepareCall("{call verifyStatus(?,?,?)}");
			cs.setString(1, userid);
			cs.setString(2, scode);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.execute();
			return cs.getString(3);
		} catch (Exception ex) {
			return ex.toString();
		}
	}

	public static String delUser(String userid) {
		try {
			CallableStatement cs = connect().prepareCall("{call delUser(?,?)}");
			cs.setString(1, userid);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			return cs.getString(2);
		} catch (Exception ex) {
			return ex.toString();
		}
	}

	public static ResultSet getUsers() throws Exception {
		return connect().prepareCall("{call getUsers()}").executeQuery();
	}

	public static ResultSet listUsers() throws Exception {
		return connect().prepareCall("{call UserList()}").executeQuery();
	}

	public static String encpt(int x) {
		String s = "";
		for (int i = 0; i < x; i++)
			s += "$";
		return s;
	}
}
