<%@include file="header.html" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<center><h2><u>USER INFORMATION</u></h2>

   
        
    <form action="NewCustomerServlet" method="POST">   <pre><br>
First Name   :<input type=text name=fname size=15 value=""><br><pre>
Last Name    :<input type=text name=lname size=15 value=""><br><pre>
Phone Number :<input type=text name=phno size=15 value=""><br><pre>
E-mail       :<input type=text name=email size=15 value=""><br><pre>
Address      :<input type=text name=address size=15 value=""> <br><pre>
City         :<input type=text name=city size=15 value=""><br><pre>
State        :<input type=text name=state size=15 value=""><br><pre>
Zip code     :<input type=text name=zipcode size=15 value="" ><br><pre>
<input bgcolor="#0000FF" type=submit value="submit" style="position: relative; width: 71; height: 28; background-color: #A0E0D0; color:black; font-weight: bold"><font size="5" color="#FF0000" ></font>
</form>
 
    <%if(session.getAttribute("error")!= null)
    {
    %>
    <%= session.getAttribute("error")%>
    <%}%>
<%@include file="footer.jsp" %>