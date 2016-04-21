<body bgcolor="lightgreen">
 <pre><h3>
 <%
    String t = (String)request.getAttribute("msg");
    if(t!=null)
      out.print(t);  
 %>
   <form action="Validate" method="POST">
       User Id  <input type="text" name="uid" placeholder="Enter User Id" required="true" />
       
       Password <input type="password" name="pass" placeholder="Enter Password" required="true" />
       
       <input type="submit" value="Sign In" />
       
       <a href="SignUp.jsp">Sign Up</a>   <a href="Forget.jsp">Forget Password</a>
       
       
       
   </form> 
 </h3></pre>  
</body>