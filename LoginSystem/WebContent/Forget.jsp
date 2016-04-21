<body bgcolor="lightgreen">
 <pre><h3>
 <%
    String t = (String)request.getAttribute("msg");
    if(t!=null)
      out.print(t);  
 %>
   <form action="ForgetAction" method="POST">
       User Id  <input type="text" name="uid" placeholder="Enter User Id" required="true" />
       
           <input type="submit" value="Forget" />
       
       <a href="SignUp.jsp">Sign Up</a>   <a href="index.jsp">Sign In</a>
       
       
       
   </form> 
 </h3></pre>  
</body>