<%@page import="java.sql.ResultSet"%>
<body bgcolor="lightyellow">
<h3><pre>
        <%
   ResultSet rs = com.db.Admin.getData();
   while(rs.next())
   {
     out.println("Empno : "+rs.getString(1));
     out.println("Ename : "+rs.getString(2));
     out.println("<img src=Photo?e="+rs.getString(1) +" height=150 width=180 style='border-radius:20px; border:3px double orange;' />"); 
     out.println("<hr size=4 color=orange>");
   }
%>