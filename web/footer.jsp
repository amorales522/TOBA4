

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<center>
    
<jsp:useBean id="date" class="java.util.Date" />
<p>Copyright © </p> <fmt:formatDate value="${date}" pattern="yyyy" />

</center>
    </body>
</html>
