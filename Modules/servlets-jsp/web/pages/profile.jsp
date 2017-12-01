<%--
  Created by IntelliJ IDEA.
  User: vladey
  Date: 27.11.17
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>

<%
    String user = null;
    if (session.getAttribute("userInfo") == null) {
        response.sendRedirect("login.html");
    } else {
        user = (String) session.getAttribute("userInfo");

    }

    String userName = null;
    String sessionID = null;

    Cookie []cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("userName")) {
            userName = cookie.getValue();
        }
        if (cookie.getName().equals("JSESSIONID")) {
            sessionID = cookie.getValue();
        }
    }
%>



<h1> Hi, <%=userName%>! Login is success! Session ID = <%=sessionID%></h1>
<h3> Here is your account info: </h3>
<h4> <%=user%></h4>
<br>
<p> You always can logout: </p>

<form action="${pageContext.request.contextPath}/pages/LogOut" method="post">
    <input type="submit" value="Logout" >
</form>


</body>
</html>
