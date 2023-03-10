<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean scope="session" id="user" class="com.dickens.users.Student"/>
<html lang="zxx">

    <head>
        <title>Ogani | Template</title>
        <jsp:include page="WEB-INF/fragments/home/head-codes.jsp"/>
    </head>

    <body>
        <jsp:include page="WEB-INF/fragments/home/header.jsp"/>
        <jsp:include page="WEB-INF/fragments/home/banner.jsp"/>
        <jsp:include page="WEB-INF/fragments/home/candidate-display.jsp"/>
        <jsp:include page="WEB-INF/fragments/home/footer.jsp"/>
        <!-- Js Plugins -->
        <jsp:include page="WEB-INF/fragments/home/scripts.jsp"/>



    </body>

</html>