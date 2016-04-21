<%@page import="java.sql.ResultSet"%>
<%
	String u = (String) session.getAttribute("id");
	String m = (String) session.getAttribute("mode");
%>
<h3>
	<tt>
		Hello
		<%=u%>, Welcome's U
		<div align="right">
			<a href="ChangePass.jsp">Change Password</a>
		</div>
		<%
			if (m.equals("ADMIN")) {
				out.println("<hr size=4 color=red><pre><form action=DelUser method=post>");
				out.println(" Select user for Delete ");
				out.println("");
				out.println("    <select name=u>");
				out.println("      <option value=''>Select User</option>");
				try {
					String s;
					ResultSet rs = com.db.Admin.getUsers();
					while (rs.next()) {
						s = rs.getString(1);
						if (!s.equals(u))
							out.println("    <option value=" + s + ">" + s + "</option>");
					}
				} catch (Exception ex) {
				}
				out.println("    </select>");
				out.println("");
				out.println(" <input type=submit value='Delete'>");
				out.println("");
				String msg = (String) request.getAttribute("msg");
				if (msg != null)
					out.println(msg);
				out.println("");
			}
			out.println("<hr size=3 color=green><a href=ListUser>List of all Users</a>");
		%>