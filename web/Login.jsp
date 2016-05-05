<%@include file="header.html" %>
<center><br><br>
<h2><u><b>CURRENT USERS LOGIN</b></u></h2><br><br>

<form action="LoginServlet" method=Post>
<h4>Enter User Name :<input type=text name="user" size=20 style="height:20;color:black"><br><br>
    User  Password  :<input type=password name ="pwd" size=20><br></h4>

<input type =submit value="LOGIN">
</form>
<H3>NEW USERS, PLEASE REGISTER NOW.</H3>
<input type=button value=REGISTER onClick="reg()">

 <input type=button value="RESET PASSWORD" onClick="reg2()">   
</center>
<%@include file="footer.jsp" %>
 
 


  