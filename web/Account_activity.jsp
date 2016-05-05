<!DOCTYPE html>

-->

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.html" %>

<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="JavaBeans.Transaction"%>
<%!List<Transaction> list ; %>
<% list =(List<Transaction>) request.getSession().getAttribute("transactions"); %>
 
    <body>
       
    <core:if test="${sessionScope.user != null}">
        <p>Welcome ${sessionScope.user.getFirstName()} ${sessionScope.user.getLastName()}</p>
        <h1>Balance in Saving Account : ${sessionScope.saving.getBalance()}</h1><br>
        <h1>Balance in Checking Account : ${sessionScope.checking.getBalance()}</h1><br>
        <h1>Transactions</h1>
        <%
        for(int i = 0 ; i < list.size() ; i++)
        { %>
        Account Id : <%= list.get(i).getAccount()%> <br>
        Amount     : <%= list.get(i).getAmount()%> <br>
        Type       : <%= list.get(i).getType()%> <br>
        Time       : <%= list.get(i).getTime()%> <br><br><br>
            
      <%  }
        %>
        <br />
    </core:if>
        <core:if test="${sessionScope.user == null}">
        <p>Not Logged In</p>
        <br />
    </core:if>

        <br />
 
<%@include file="footer.jsp" %>