<%--
    Document   : profile
    Created on : Feb 26, 2023, 4:38:34 PM
    Author     : BLAZE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean scope="session" id="user" class="com.dickens.users.Student"/>
<jsp:useBean scope="session" id="elecoadmin" class="com.dickens.users.ElecoAdmin"/>
<jsp:useBean scope="session" id="candidate" class="com.dickens.users.Candidate"/>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/fragments/dashboard/head-codes.jsp"/>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/fragments/dashboard/header.jsp"/>
        <jsp:include page="WEB-INF/fragments/dashboard/sidebar.jsp"/>
        <jsp:include page="WEB-INF/fragments/dashboard/profile-body.jsp"/>
        <jsp:include page="WEB-INF/fragments/dashboard/footer.jsp"/>
        <jsp:include page="WEB-INF/fragments/dashboard/scripts.jsp"/>
    </body>
</html>
