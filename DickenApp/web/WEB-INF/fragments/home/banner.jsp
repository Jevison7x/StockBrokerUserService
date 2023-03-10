<%--
    Document   : banner
    Created on : Feb 25, 2023, 12:14:25 AM
    Author     : BLAZE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Hero Section Begin -->
<section class="hero">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="hero__categories">
                    <div class="hero__categories__all">
                        <i class="fa fa-bars"></i>
                        <span>All departments</span>
                    </div>
                    <ul>
                        <li><a href="home?position=president">Presidential</a></li>
                        <li><a href="home?position=vp">Vice President</a></li>
                        <li><a href="home?position=fs">Financial Secretary</a></li>
                        <li><a href="home?position=dos">Director of Socials</a></li>
                        <li><a href="home?position=doi">Director of Information</a></li>
                        <li><a href="home?position=sg">Secretary General</a></li>
                        <li><a href="home?position=dow">Director of Welfare</a></li>
                        <li><a href="home?position=dosp">Director of Sport</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="hero__search">
                    <div class="hero__search__form">
                        <form action="#">
                            <input type="text" placeholder="What do yo u need?">
                            <button type="submit" class="site-btn">SEARCH</button>
                        </form>
                    </div>
                </div>
                <div class="hero__item set-bg" data-setbg="img/hero/banner.jpg">
                    <div class="hero__text">
                        <span>FRUIT FRESH</span>
                        <h2>Vegetable <br />100% Organic</h2>
                        <p>Free Pickup and Delivery Available</p>
                        <a href="#" class="primary-btn">SHOP NOW</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Hero Section End -->
