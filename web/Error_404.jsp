

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
 
<% response.setStatus(404); %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>404 error</title>
  </head>
  <body>
      <h1>Page not found!!! <%= response.getStatus() %> </h1>
  </body>
</html>