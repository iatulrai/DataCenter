package com.work;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Blob;
		
public class Photo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empno = request.getParameter("e");
		try {
			ResultSet rs = com.db.Admin.getPhoto(empno);
			if (rs.next()) {
				Blob ph = (Blob) rs.getBlob(1);
				byte data[] = ph.getBytes(1, (int) ph.length());
				ServletOutputStream out = response.getOutputStream();
				out.write(data);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

}