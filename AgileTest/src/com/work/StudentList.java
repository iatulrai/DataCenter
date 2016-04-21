package com.work;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSetMetaData;

public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<body><tt><table border=1 width=90%><tr>");

		try {

			ResultSet rs = com.db.Admin.getStudent();

			ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();

			int NOC = md.getColumnCount();
			
			for (int i =1 ; i <= NOC; i++) {
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
