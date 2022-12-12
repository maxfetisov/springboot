<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Покупки</title>
    <meta charset="UTF-8">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>
</head>
<body>
<div class="back-btn" onclick="location.href='/1'"><</div>
<div class="header">Таблица "Покупки"</div>
<div class="output">
<table>
    <tr>
    <th>number</th>
    <th>personId</th>
    <th>goodId</th>
    </tr>
    <c:forEach items="${purchaseList}" var="item">
        <tr>
            <td>${item.number}</td>
            <td>${item.personId}</td>
            <td>${item.goodId}</td>
        </tr>
    </c:forEach>
</table>
</div>
    <div class="input">
        <div class="edit unselected" onclick="changePurchaseInputs(1)">Добавление</div>
        <div class="edit unselected" onclick="changePurchaseInputs(2)">Обновление</div>
        <div class="edit unselected" onclick="changePurchaseInputs(3)">Удаление</div>
<form id="form" action="purchase/create" method="post">
    <input class="input-box" type="text" name="number" id="number" placeholder="number">
    <input class="input-box" type="text" name="personId" id="personId" placeholder="personId">
    <input class="input-box" type="text" name="goodId" id="goodId" placeholder="goodId">
    <input class="input-btn" type="submit" name="submitButton">
</form>

    </div>

</body>
</html>