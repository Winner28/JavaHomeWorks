<%--
  Created by IntelliJ IDEA.
  User: vladey
  Date: 23.11.17
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <h1> Hello, user!</h1>

  <form action="${pageContext.request.contextPath}/pages/login.html" method="post">
      <input type="submit" value="Go to login page">
  </form>



  </body>
</html>