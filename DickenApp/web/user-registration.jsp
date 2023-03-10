<%--
    Document   : user-registration
    Created on : Feb 25, 2023, 1:50:38 PM
    Author     : BLAZE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/fragments/dashboard/head-codes.jsp"/>
        <title>Register</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/fragments/dashboard/registration-body.jsp"/>
        <jsp:include page="WEB-INF/fragments/dashboard/scripts.jsp"/>
        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

    </body>
</html>
