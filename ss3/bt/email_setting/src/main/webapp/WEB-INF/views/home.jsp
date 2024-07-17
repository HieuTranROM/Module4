<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail Setting</title>
</head>
<body>
<h1>Settings</h1>
<p style="color: blue">${message}</p>
<form:form modelAttribute="emailList" method="post">
    <table>
        <tr>
            <td> Language:</td>
            <td>
                <form:select path="language" items="${language}">
                </form:select>
            </td>
        </tr>
        <tr>
            <td> Page size: </td>
            <td>
                Show <form:select path="pageSize" items="${size}"></form:select> emails per page
            </td>
        </tr>
        <tr>
            <td>
                Spams filter:
            </td>
            <td>
                <form:checkbox path="spamsFilter"/> Enable spams filter
            </td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>
                <form:textarea path="signature"></form:textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button type="submit" value="Update">Update</form:button>
                <form:button type="button" value="Cancel">Cancel</form:button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>