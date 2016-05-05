<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="JavaBeans.User"%>
<%!ArrayList<User> list = new ArrayList<User>(); %>
<% list =(ArrayList<User>) request.getSession().getAttribute("Users"); %>
<html>
    <head>
        <meta charset="utf-8">
        <title>Administrative Login</title>
        <link rel="stylesheet" href="../styles/main.css" type="text/css"/>
        <style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
</style>
    </head>
    <body>
        <h1>Reports</h1>
        <form method="GEt" action="${pageContext.request.contextPath}/ReportsServlet">
            <input name ="Submit" type="submit" value="Show Reports" />
            <input name ="Submit" type="submit" value="Get SpreadSheet" />
        </form>
        
        <table>
  <tr>
    <th>Id</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Username</th>
    <th>Address</th>
    <th>Phone Number</th>
    <th>City</th>
    <th>State</th>
    <th>Email</th>
    <th>Zip Code</th>
  </tr>
  <%
    if(request.getSession().getAttribute("Users") != null)
    {
        for(int i = 0 ; i < list.size() ; i++)
        { %>
  <tr>
    <td><%= list.get(i).getId()%></td>
    <td><%= list.get(i).getFirstName()%></td>
    <td><%= list.get(i).getLastName()%></td>
    <td><%= list.get(i).getUsername()%></td>
    <td><%= list.get(i).getAddress()%></td>
    <td><%= list.get(i).getPhoneNumber()%></td>
    <td><%= list.get(i).getCity()%></td>
    <td><%= list.get(i).getState()%></td>
    <td><%= list.get(i).getEmail()%></td>
     <td><%= list.get(i).getZipCode()%></td>
  </tr>
<%  }
    } %>
</table>
    </body>
</html>