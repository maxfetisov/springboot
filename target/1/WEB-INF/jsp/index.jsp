<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC Demo</title>
    <meta charset="windows-1251">
</head>
<body>
<table>
    <th>
        <td>id</td>
        <td>name</td>
    </th>
<c:forEach items="${personList}" var="item">
    <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
    </tr>
</c:forEach>
    <p>Добавление:</p>
    <form action="create" method="post">
        <input type="text" name="id">
        <input type="text" name="name">
        <input type="submit" name="submitButton">
    </form>
    <p>Обновление:</p>
    <form action="update" method="post">
        <input type="text" name="id">
        <input type="text" name="name">
        <input type="submit" name="submitButton">
    </form>
    <p>Удаление:</p>
    <form action="delete" method="post">
        <input type="text" name="id">
        <input type="submit" name="submitButton">
    </form>
</table>
</body>
</html>