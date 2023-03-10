<%--
    Document   : candidates-body
    Created on : Feb 25, 2023, 12:40:42 AM
    Author     : BLAZE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Organi Shop</h2>
                    <div class="breadcrumb__option">
                        <a href="./index.html">Home</a>
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->
<section class="product spad">
    <div class="container">
        <div class="filter__item">
            <div class="row">
                <div class="col-lg-4 col-md-5">
                    <div class="filter__sort">
                        <span>Sort By</span>
                        <select>
                            <option value="0">Default</option>
                            <option value="0">Default</option>
                        </select>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4">
                    <div class="filter__found">
                        <h6><span>${candidatesFound}</span> Candidates found</h6>
                    </div>
                </div>
                <div class="col-lg-4 col-md-3">
                    <div class="filter__option">
                        <span class="icon_grid-2x2"></span>
                        <span class="icon_ul"></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach var="candidate" items="${candidates}">
                <c:set var="candidate" value="${candidate}"/>
                <jsp:useBean id="candidate" class="com.dickens.users.Candidate"/>
                <div class="col-lg-4 col-md-6 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="img/product/product-1.jpg">
                            <ul class="product__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#">${candidate.name}</a></h6>
                            <a href="get-details?canId=${candidate.name}" class="btn btn-success">vote</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <!-- Product Section End -->
</section>
