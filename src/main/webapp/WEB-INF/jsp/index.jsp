<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Главная страница</title>
    <meta charset="UTF-8">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="header main-header">Выбор таблицы:</div>
    <div class="main-menu-btn" onclick="location.href='/1/person'">Пользователи</div><br/>
    <div class="main-menu-btn" onclick="location.href='/1/good'">Товары</div><br/>
    <div class="main-menu-btn" onclick="location.href='/1/purchase'">Покупки</div><br/>
</body>
</html>
