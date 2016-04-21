<body bgcolor="lightgreen">
 <pre><h3>
 <%
   String id = (String)session.getAttribute("id");
   out.println("<div align=right>Welcome "+id+"</div>");
    String t = (String)request.getAttribute("msg");
    if(t!=null)
      out.print(t);  
 %>
   <form action="ChangePassAction" method="POST">
       Old Password <input type="password" name="op" placeholder="Enter Old Password" required="true" />
       
       New Password <input type="password" name="np" placeholder="Enter New Password" required="true" />
       
       <input type="submit" value="Change Password" />
       
       <a href="SignUp.jsp">Sign Up</a>   <a href="index.jsp">Sign In</a>
   </form> 
 </h3></pre>  
</body>