<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Пользователи</title>
    <meta charset="UTF-8">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>
</head>
<body>
<div class="back-btn" onclick="location.href='/1'"><</div>
<div class="header">Таблица "Пользователи"</div>
<div class="output">
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>login</th>
        <th>password</th>
        <th>email</th>
    </tr>
<c:forEach items="${personList}" var="item">
    <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.login}</td>
        <td>${item.password}</td>
        <td>${item.email}</td>
    </tr>
</c:forEach>
</table>
</div>
<div class="input">
    <div class="edit unselected" onclick="changePersonInputs(1)">Добавление</div>
    <div class="edit unselected" onclick="changePersonInputs(2)">Обновление</div>
    <div class="edit unselected" onclick="changePersonInputs(3)">Удаление</div>
    <form id = "form" action="person/create" method="post" >
        <input class="input-box" type="text" name="id" id = "id" placeholder="id">
        <input class="input-box" type="text" name="name" id = "name" placeholder="name">
        <input class="input-box" type="text" name="login" id = "login" placeholder="login">
        <input class="input-box" type="text" name="password" id = "password" placeholder="password">
        <input class="input-box" type="text" name="email" id = "email" placeholder="email">
        <input class="input-btn" type="submit" name="submitButton" value="Подтвердить">
    </form>
</div>
</body>
</html>