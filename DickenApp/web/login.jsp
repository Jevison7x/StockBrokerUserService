<%--
    Document   : login
    Created on : Feb 25, 2023, 1:42:05 PM
    Author     : BLAZE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/fragments/dashboard/head-codes.jsp"/>
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/fragments/dashboard/login-body.jsp"/>
        <jsp:include page="WEB-INF/fragments/dashboard/scripts.jsp"/>
    </body>
</html>
