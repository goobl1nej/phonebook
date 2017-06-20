<%--
  Created by IntelliJ IDEA.
  ru.test.User: root
  Date: 24.05.2017
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
<%  String userIdParam=request.getParameter("userID");
    if(userIdParam!=null && !userIdParam.isEmpty()) {
%>
<form action="<c:url value="/phonebook"/>" method="POST">
    <input type="hidden" name="userID" value="<%=userIdParam %>"/>
    <table>
        <tr>
            <td>Ваша почта:</td><td><input type="text" name="email" value="${email}"/></td>
            <td><input type="submit" value="Добавить" name="AddEmail"/></td>
        </tr>
    </table>
</form>
<% } else {
        %>Не указан идентификатор пользователя!<%
}%>
</body>
</html>
