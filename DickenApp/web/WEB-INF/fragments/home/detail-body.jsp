<%--
    Document   : detail-body
    Created on : Feb 25, 2023, 12:51:11 AM
    Author     : BLAZE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Candidate Detaila</h2>
                    <div class="breadcrumb__option">
                        <a href="./index.html">Home</a>
                        <a href="./index.html">Candidate</a>
                        <span>${canName} Details</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Product Details Section Begin -->
<section class="product-details spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6">
                <div class="product__details__pic">
                    <div class="product__details__pic__item">
                        <img class="product__details__pic__item--large"
                             src="img/product/details/product-details-1.jpg" alt="">
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="product__details__text">
                    <h3>${canName}</h3>
                    <div class="product__details__price">${canPosition}</div>
                    <p>${canManifesto}</p>
                    <input hidden="" id="canId" value="${canName}"/>
                    <input hidden="" id="votingPin" value="${user.votingPin}"/>
                    <button id="vote" class="primary-btn">Vote</button>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Footer Section Begin -->
