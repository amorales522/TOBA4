

<%@include file="header.html" %>
    <center>
        <form action="ChangePasswordServlet" method="Post"><br>
            
            Previous Password  : ${sessionScope.user.getPassword()}<br><br>
            New Password  :<input type=text name=newpass size=15 value=""><br><br>
         <input bgcolor="#0000FF" type=submit value="submit"  style="position: relative; width: 71; height: 28; background-color: #A0E0D0; color:black; font-weight: bold"><font size="5" color="#FF0000" ></font>
        </form>
    </center>
<%@include file="footer.jsp" %>
