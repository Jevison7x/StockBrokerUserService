<%--
    Document   : candidate-display
    Created on : Feb 25, 2023, 12:16:11 AM
    Author     : BLAZE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Featured Section Begin -->
<section class="featured spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h2>Featured Candidates</h2>
                </div>
            </div>
        </div>
        <div class="row featured__filter">
            <c:forEach var="candidate" items="${candidates}">
                <c:set var="candidate" value="${candidate}"/>
                <jsp:useBean id="candidate" class="com.dickens.users.Candidate"/>
                <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-1.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">${candidate.name}</a></h6>
                            <h5>${candidate.position}</h5>
                            <a href="get-details?canId=${candidate.name}" class="btn btn-success">vote</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- Featured Section End -->
