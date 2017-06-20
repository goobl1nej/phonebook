<%--
  Created by IntelliJ IDEA.
  ru.test.User: root
  Date: 22.05.2017
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title></title>
</head>
    <body>
    <form action="<c:url value="/edit"/>" method="POST">

                <input type="hidden" name="userID" value="${user.id}"/>
                <table align="center">
                    <tr>
                        <td>Фамилия:</td><td><input type="text" name="lastName" value="${user.lastname}"/></td>
                    </tr>
                    <tr>
                        <td>Имя:</td><td><input type="text" name="firstName" value="${user.firstname}"/></td>
                    </tr>
                    <tr>
                        <td>Отчество:</td><td><input type="text" name="middleName" value="${user.middlename}"/></td>
                    </tr>
                    <tr>
                        <td>Дата рождения:</td>
                        <td><div title="Введите дату в формате dd.MM.yyyy"><input type="text" pattern="[0-9]{2}.[0-9]{2}.[0-9]{4}" name="birthday" value='<fmt:formatDate pattern = "dd.MM.yyyy" value = "${user.birthday}" />'/></div></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Сохранить" name="editUser"/></td>
                    </tr>
                </table>

        <c:if test="${user==null}">
            Пользователей не найдено
            </c:if>
    </form>
    <tr>
    <td><a href="phonebook?action=all">К списку пользователей</a></td>
    </tr>

    </body>
</html>
