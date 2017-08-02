<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
<%  String userIdParam=request.getParameter("userID");
    String phoneIdParam=request.getParameter("phoneID");
    String phone=request.getParameter("phone");
    if(userIdParam!=null && !userIdParam.isEmpty()) {
    if(phoneIdParam!=null && !phoneIdParam.isEmpty()) {
%>
<form action="<c:url value="/phonebook"/>" method="POST">
    <input type="hidden" name="userID" value="<%=userIdParam%>"/>
    <input type="hidden" name="phoneID" value="<%=phoneIdParam%>"/>
    <table>
        <tr>
            <td>Ваш телефон:</td><td><input type="text" name="phone" value="<%=phone%>"/></td>
            <td><input type="submit" name="EditPhone" value="Обновить"></td>
        </tr>
    </table>
</form>
<% }
    } else {
%>Не указан идентификатор пользователя!<%
    }%>
</body>
</html>
