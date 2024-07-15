<%--
  Created by IntelliJ IDEA.
  User: trung
  Date: 7/15/2024
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gia vị đã chọn</title>
</head>
<body>
<h2>Gia vị đã chọn:</h2>
<ul>
    <c:forEach var="condiment" items="${selected}">
        <li>Bạn đã chọn ${condiment},làm gia vị cho bánh sandwich của mình</li>
    </c:forEach>
</ul>
</body>
</html>