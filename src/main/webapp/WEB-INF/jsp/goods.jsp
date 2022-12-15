<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Товары</title>
    <meta charset="UTF-8">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>
</head>
<body>
<div class="back-btn" onclick="location.href='/1'"><</div>
<div class="header">Таблица "Товары"</div>
<div class="output">
<table>
    <tr>
    <th>id</th>
    <th>name</th>
    <th>price</th>
    </tr>
    <c:forEach items="${goodList}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
        </tr>
    </c:forEach>
</table>
</div>
<div class="input">
    <div class="edit unselected" onclick="changeGoodInputs(1)">Добавление</div>
    <div class="edit unselected" onclick="changeGoodInputs(2)">Обновление</div>
    <div class="edit unselected" onclick="changeGoodInputs(3)">Удаление</div>
<form id="form" action="good/create" method="post">
    <input class="input-box" type="text" name="id" id="id" placeholder="id">
    <input class="input-box" type="text" name="name" id="name" placeholder="name">
    <input class="input-box" type="text" name="price" id="price" placeholder="price">
    <input class="input-btn" type="submit" name="submitButton">
</form>

</div>

</body>
</html>