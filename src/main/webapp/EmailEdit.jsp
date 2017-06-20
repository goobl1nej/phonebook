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
    String emailIdParam =request.getParameter("emailID");
    String email=request.getParameter("email");
    if(userIdParam!=null && !userIdParam.isEmpty()) {
    if(emailIdParam !=null && !emailIdParam.isEmpty()) {
%>
<form action="<c:url value="/phonebook"/>" method="POST">
    <input type="hidden" name="userID" value="<%=userIdParam%>"/>
    <input type="hidden" name="emailID" value="<%=emailIdParam%>"/>
    <table>
        <tr>
            <td><input type="text" name="email" value="<%=email%>"/></td>
            <td><input type="submit" name="EditEmail" value="Обновить"></td>
        </tr>
    </table>
</form>
<% }
} else {
%>Не указан идентификатор пользователя!<%
}%>
</body>
</html>
