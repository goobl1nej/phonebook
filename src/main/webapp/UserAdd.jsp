<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  ru.test.User: root
  Date: 23.05.2017
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="<c:url value="/edit"/>" method="POST">
    <table align="center">
        <tr>
            <td align="right">Фамилия:</td><td><input type="text" name="lastName" value="${lastname}"/></td>
        </tr>
        <tr>
            <td align="right">Имя:</td><td><input type="text" name="firstName" value="${firstname}"/></td>
        </tr>
        <tr>
            <td align="right">Отчество:</td><td><input type="text" name="middleName" value="${middlename}"/></td>
        </tr>
        <tr>
            <td align="right">Дата рождения:</td><td><div title="Введите дату в формате dd.MM.yyyy"><input type="text" pattern="[0-9]{2}.[0-9]{2}.[0-9]{4}" name="birthday" value="${birthday}"/></div></td>
        </tr>
        <tr>
            <td align="right">Электронная почта:</td><td><input type="text" name="email" value="${email}"/></td>
        </tr>
        <tr>
            <td align="right">Телефон:</td><td><input type="text" name="phone" value="${phone}"/></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="Создать" name="OK"/></td>
        </tr>
    </table>
</form>
</body>
</html>
