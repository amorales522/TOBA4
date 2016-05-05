<!DOCTYPE html>

<%@include file="header.html" %>
<center><h2>Your account have been successfully created</h2>
    
    
    Username     = ${sessionScope.user.getUsername()}<br><br>
    Password     = ${sessionScope.user.getPassword()}<br><br>
    First Name   = ${sessionScope.user.getFirstName()}<br><br>
    Last Name    = ${sessionScope.user.getLastName()}<br><br>
    Email        = ${sessionScope.user.getEmail()}<br><br>
    Address      = ${sessionScope.user.getAddress()}<br><br>
    Phone Number = ${sessionScope.user.getPhno()}<br><br>
    City         = ${sessionScope.user.getCity()}<br><br>
    State        = ${sessionScope.user.getState()}<br><br>
    Zip Code     = ${sessionScope.user.getZipCode()}<br><br>
       
<a href="index.jsp">back</a>
</center>

<%@include file="footer.jsp" %>
