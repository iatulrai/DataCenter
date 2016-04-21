<%
   String u = request.getParameter("uid");
   String p = request.getParameter("ps");
   if(p.equals("agile"))
   {
 %>
 <jsp:forward page="Cook1.jsp" ></jsp:forward>
 <%}else { %>
<jsp:forward page="Login.jsp?t=0" ></jsp:forward>
 <%} %>
 