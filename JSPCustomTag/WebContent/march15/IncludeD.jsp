<h2><tt>
<%
   String u = request.getParameter("uid");
   String p = request.getParameter("ps");
   if(p.equals("agile"))
   {
     out.println("Hello "+u+", Welcome's U");
     out.close();
   }      
 %>
 Sorry this invalid Login id& Password , re-enter plz.</tt></h2>
 <%@include file="Login.jsp" %>
 