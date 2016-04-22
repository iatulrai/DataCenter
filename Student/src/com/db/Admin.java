package com.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class Admin {
	public static Connection connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
	}

	public static List<String> getCollege() {
		List<String> cgList = new ArrayList<>();

		try {
			ResultSet rs = connect().prepareCall("{call getCollege()}").executeQuery();
			while (rs.next()) {
				cgList.add(rs.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			cgList.add(e.getMessage());
		}
		return cgList;

	}

	public static List<String> getState() {
		List<String> sList = new ArrayList<>();

		try {
			ResultSet rs = connect().prepareCall("{call getState()}").executeQuery();
			while (rs.next()) {
				sList.add(rs.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			sList.add(e.getMessage());
		}
		return sList;

	}

	public static List<String> getCity(String state) {
		List<String> cList = new ArrayList<>();

		try {
			CallableStatement cs = connect().prepareCall("{call getCity(?)}");
			cs.setString(1, state);
			ResultSet rs = cs.executeQuery();
			while (rs.next())
				cList.add(rs.getString(1));
		} catch (Exception ex) {
			cList.add(ex.getMessage());
		}
		return cList;

	}

	public static List<String> getRecord(String roll) {
		List<String> rec = new ArrayList<>();
		try {
			CallableStatement cs = connect().prepareCall("{call getRecord(?)}");
			cs.setString(1, roll);
			ResultSet rs = cs.executeQuery();
			if (rs.next()) {
				rec.add(rs.getString(2));
				rec.add(rs.getString(3));
				rec.add(rs.getString(4));
				rec.add(rs.getString(5));
			}
			return rec;
		} catch (Exception e) {
			// TODO: handle exception
			rec.add(e.getMessage());
			return rec;
		}
	}

	public static List<String> getRoll() {
		List<String> rList = new ArrayList<>();
		try {
			ResultSet rs = connect().prepareCall("{call getRoll()}").executeQuery();
			while (rs.next()) {
				rList.add(rs.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			rList.add(e.getMessage());
		}
		return rList;
	}

	public static String addStudent(String name, String college, String state, String city) {
		try {
			CallableStatement cs = connect().prepareCall("{call ADDUPDSTUDENT(?,?,?,?,?,?,?)}");
			cs.setString(1, "I");
			cs.setString(2, "0");
			cs.setString(3, name);
			cs.setString(4, college);
			cs.setString(5, state);
			cs.setString(6, city);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.execute();
			return cs.getString(7);
		} catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}
	}

	public static String updStudent(String roll, String name, String college, String state, String city) {
		try {
			CallableStatement cs = connect().prepareCall("{call ADDUPDSTUDENT(?,?,?,?,?,?,?)}");
			cs.setString(1, "U");
			cs.setString(2, roll);
			cs.setString(3, name);
			cs.setString(4, college);
			cs.setString(5, state);
			cs.setString(6, city);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.execute();
			return cs.getString(7);
		} catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}
	}

	public static String delStu(String roll) {
		try {
			CallableStatement cs = connect().prepareCall("{call delRecord(?,?)}");
			cs.setString(1, roll);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.executeQuery();
			return cs.getString(2);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static ResultSet getPReport(String name) throws Exception {
		CallableStatement cs = connect().prepareCall("{call getPReport(?)}");
		cs.setString(1, name);
		return cs.executeQuery();
	}

	public static ResultSet getReport() throws Exception {
		return connect().prepareCall("{call getReport()}").executeQuery();
	}

}
