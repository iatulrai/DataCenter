package com.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class Admin {
	public static Connection connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/india", "root", "");
	}

	public static ResultSet getData() throws Exception {
		return connect().prepareCall("{call getData()}").executeQuery();
	}

	public static String addEmp(String ename, String sal, String deptno, String mobile) {
		try {
			CallableStatement cs = connect().prepareCall("{call addUpdEmp(?,?,?,?,?,?,?)}");
			cs.setString(1, "I");
			cs.setString(2, "0");
			cs.setString(3, ename);
			cs.setString(4, sal);
			cs.setString(5, deptno);
			cs.setString(6, mobile);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.execute();
			return cs.getString(7); // return the out parameter value.
		} catch (Exception ex) {
			return ex.toString();
		}
	}

	public static String updEmp(String empno, String ename, String sal, String deptno, String mobile) {
		try {
			CallableStatement cs = connect().prepareCall("{call addUpdEmp(?,?,?,?,?,?,?)}");
			cs.setString(1, "U");
			cs.setString(2, empno);
			cs.setString(3, ename);
			cs.setString(4, sal);
			cs.setString(5, deptno);
			cs.setString(6, mobile);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.execute();
			return cs.getString(7); // return the out parameter value.
		} catch (Exception ex) {
			return ex.toString();
		}
	}

	public static String delEmp(String empno) {
		try {
			CallableStatement cs = connect().prepareCall("{call delEmp(?,?)}");
			cs.setString(1, empno);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			return cs.getString(2); // return the out parameter value.
		} catch (Exception ex) {
			return ex.toString();
		}
	}

	public static ResultSet getEmp(String empno) throws Exception {
		CallableStatement cs = connect().prepareCall("{call getEmp(?)}");
		cs.setString(1, empno);
		return cs.executeQuery();
	}
}
