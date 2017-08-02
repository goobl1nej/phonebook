<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>Контакт</title>
  </head>
  <body>
  <form action="<c:url value="/phonebook"/>" method="POST">
    <table align="center">
      <tr>
        <td><a href="phonebook?action=all">Все контакты</a></td>
      </tr>
      <tr>
        <td>Введите id контакта</td><td><input type="text" name="userID" value="${userID}"></td>
        <td></td><td><input type="submit" value="Показать" name="View"/></td>
      </tr>
    </table>
  </form>
  </body>
</html>
