<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Список пользователей</title>
    <style type="text/css">
        .cell {
            padding: 5px 10px;
        }
    </style>
</head>
<body>
<form action="<c:url value="/edit"/>" method="POST">
    <table align="center" width="50%" style="margin-bottom: 10px;">
        <tr>
            <td align="left" class="cell">
                <a href="index.jsp">
                    <img src="images/home.png" width="50px" height="50px">
                </a>
                <a href="phonebook?action=add">
                    <img src="images/addcard.jpg" width="50px" height="50px">
                    <%--<button style="padding: 7px 20px">Создать контакт</button>--%>
                </a>
            </td>
        </tr>
    </table>


    <c:if test="${userList!=null}">
        <table align="center" width="50%" border="1">
            <tr>
                <td align="center" class="cell">Фамилия:</td>
                <td align="center" class="cell">Имя:</td>
                <td align="center" class="cell">Дата рождения:</td>
                <td></td>
            </tr>

            <c:forEach var="user" items="${userList}">
                <tr>
                    <td class="cell">${user.lastname}</td>
                    <td class="cell">${user.firstname}</td>
                    <td class="cell"><fmt:formatDate pattern = "dd.MM.yyyy" value = "${user.birthday}" /></td>
                    <%--<td class="cell">${user.birthday}</td>--%>
                    <td class="cell"><a href="phonebook?action=view&userID=${user.id}">Карточка пользователя</a></td>
                </tr>
            </c:forEach>

        </table>
    </c:if>

    <c:if test="${userList==null}">
        Пользователей не найдено
    </c:if>
</form>


</body>
</html>
