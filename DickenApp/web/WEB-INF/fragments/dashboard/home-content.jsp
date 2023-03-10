<%--
    Document   : home-content
    Created on : Feb 25, 2023, 1:16:33 AM
    Author     : BLAZE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="candidateName" value="${candidate.name}"/>
<c:set var="elecoadminName" value="${elecoadmin.username}"/>
<main id="main" class="main">

    <div class="pagetitle">
        <h1>Dashboard</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
                <li class="breadcrumb-item active">Dashboard</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section dashboard">
        <div class="row">

            <!-- Left side columns -->
            <div class="col-lg-8">
                <div class="row">

                    <!-- Reports -->
                    <div class="col-12">
                        <div class="card">

                            <div class="filter">
                                <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                    <li class="dropdown-header text-start">
                                        <h6>Filter</h6>
                                    </li>

                                    <li><a class="dropdown-item" href="#">Today</a></li>
                                    <li><a class="dropdown-item" href="#">This Month</a></li>
                                    <li><a class="dropdown-item" href="#">This Year</a></li>
                                </ul>
                            </div>

                            <div class="card-body">
                                <h5 class="card-title">Reports <span>/Today</span></h5>

                                <!-- Line Chart -->
                                <div id="reportsChart"></div>

                                <!-- End Line Chart -->

                            </div>

                        </div>
                    </div><!-- End Reports -->

                    <!-- Recent Sales -->
                    <div class="col-12">
                        <div class="card recent-sales overflow-auto">
                            <div class="card-body">
                                <h5 class="card-title">Manage Candidates</h5>
                                <table class="table table-borderless" id="manageCandidate">
                                    <thead>
                                        <tr>
                                            <th scope="col">Id</th>
                                            <th scope="col">Candidate Name</th>
                                            <th scope="col">Position Running</th>
                                            <th scope="col">Disqualify</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div><!-- End Recent Sales -->

                    <!-- Top Selling -->
                    <div class="col-12">
                        <form action="create-new-pin" method="POST"> <button class="btn btn-primary mb-2" type="submit"><i class="bi-key"></i> Generate Pin</button></form>

                        <div class="card top-selling overflow-auto">
                            <div class="card-body pb-0">
                                <h5 class="card-title">Pins</h5>

                                <table class="table table-borderless" id="itemTable">
                                    <thead>
                                        <tr>
                                            <th scope="col">s/n</th>
                                            <th scope="col">pinId</th>
                                            <th scope="col">status</th>
                                            <th scope="col">dateIssued</th>
                                            <th scope="col">dateUsed</th>
                                            <th scope="col">usedBy</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div><!-- End Top Selling -->
                </div>
            </div><!-- End Left side columns -->
            <!-- Right side columns -->
            <div class="col-lg-4">
                <!-- Recent Activity -->
                <c:choose>
                    <c:when test="${elecoadminName ne null}">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Number of Students</h5>
                                <div class="d-flex align-items-center">
                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                        <i class="bi bi-cart"></i>
                                    </div>
                                    <div class="ps-3">
                                        <h6>145</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Number of Candidates</h5>
                                <div class="d-flex align-items-center">
                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                        <i class="bi bi-cart"></i>
                                    </div>
                                    <div class="ps-3">
                                        <h6>145</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Set Election Dte</h5>
                                <div class="align-items-center">
                                    <form>
                                        <label for="inputDate" class="col-sm-2 col-form-label" style="width: 100%">Start Date</label>
                                        <div class="col-sm-10">
                                            <input type="date" class="form-control">
                                        </div>
                                        <label for="inputDate" class="col-sm-2 col-form-label" style="width: 100%">End Date</label>
                                        <div class="col-sm-10">
                                            <input type="date" class="form-control">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${candidateName ne null}">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Number of Votes</h5>
                                <div class="d-flex align-items-center">
                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                        <i class="bi bi-cart"></i>
                                    </div>
                                    <div class="ps-3">
                                        <h6>145</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
                <!-- End Recent Activity -->
            </div><!-- End Right side columns -->

        </div>
    </section>

</main>
<!-- End #main -->
