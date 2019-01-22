<%-- 
    Document   : table
    Created on : Nov 6, 2018, 9:19:07 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <c:forEach items="${list}" var="rapper">
            <tr>
                <td>${rapper.getName()}</td>
                <td></td>
            </tr> 
            </c:forEach>
        </table>
    </body>
</html>
