<%--
    Document   : profile-body
    Created on : Feb 26, 2023, 4:40:10 PM
    Author     : BLAZE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean scope="session" id="user" class="com.dickens.users.Student"/>
<jsp:useBean scope="session" id="elecoadmin" class="com.dickens.users.ElecoAdmin"/>
<jsp:useBean scope="session" id="candidate" class="com.dickens.users.Candidate"/>
<c:set var="candidateName" value="${candidate.name}"/>
<c:set var="elecoadminName" value="${elecoadmin.username}"/>
<c:set var="studentName" value="${user.name}"/>
<main id="main" class="main">
    <div class="pagetitle">
        <h1>Profile</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item">Users</li>
                <li class="breadcrumb-item active">Profile</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section profile">
        <div class="row">
            <div class="col-xl-4">

                <div class="card">
                    <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
                        <c:choose>
                            <c:when test="${user.name ne null}">
                                <img src="img/${user.imgName}" alt="Profile" class="rounded-circle">
                                <h2>Kevin Anderson</h2>
                                <h3>Web Designer</h3>
                                <div class="social-links mt-2">
                                    <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                                    <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                                    <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                                    <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
                                </div>
                            </c:when>
                            <c:when test="${candidate.name ne null}">
                                <img src="img/${candidate.imgName}" alt="Profile" class="rounded-circle">
                                <h2>Kevin Anderson</h2>
                                <h3>Web Designer</h3>
                                <div class="social-links mt-2">
                                    <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                                    <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                                    <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                                    <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
                                </div></c:when>
                            <c:when test="${elecoadmin.username ne null}">
                                <img src="img/${elecoadmin.imgName}" alt="Profile" class="rounded-circle">
                                <h2>Kevin Anderson</h2>
                                <h3>Web Designer</h3>
                                <div class="social-links mt-2">
                                    <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                                    <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                                    <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                                    <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
                                </div></c:when>
                        </c:choose>
                    </div>
                </div>

            </div>

            <div class="col-xl-8">
                <div class="card">
                    <div class="card-body pt-3">
                        <!-- Bordered Tabs -->
                        <ul class="nav nav-tabs nav-tabs-bordered">
                            <li class="nav-item">
                                <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Overview</button>
                            </li>
                            <li class="nav-item">
                                <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">Edit Profile</button>
                            </li>
                            <li class="nav-item">
                                <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-change-password">Change Password</button>
                            </li>

                        </ul>
                        <div class="tab-content pt-2">
                            <c:choose>
                                <c:when test="${user.name ne null}">
                                    <div class="tab-pane fade show active profile-overview" id="profile-overview">
                                        <h5 class="card-title">Profile Details</h5>
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label ">Full Name</div>
                                            <div class="col-lg-9 col-md-8">${studentName}</div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Department</div>
                                            <div class="col-lg-9 col-md-8">${user.department}</div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Level</div>
                                            <div class="col-lg-9 col-md-8">${user.level}</div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Faculty</div>
                                            <div class="col-lg-9 col-md-8">${user.faculty}</div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Matric Number</div>
                                            <div class="col-lg-9 col-md-8">${user.matricNumber}</div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Voting Pin</div>
                                            <div class="col-lg-9 col-md-8">${user.votingPin}</div>
                                        </div>
                                    </div>
                                    <div class="tab-pane fade profile-edit pt-3" id="profile-edit">
                                        <!-- Profile Edit Form -->
                                        <form action="update" method="POST" enctype="multipart/form-data">
                                            <div class="row mb-3">
                                                <label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Upload Profile Image</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="file" name="file"/>
                                                        <input hidden="" value="edit-student" name="criteria"/>
                                                        <input hidden="" value="${user.name}" name="studentId"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="company" class="col-md-4 col-lg-3 col-form-label">Faculty</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="faculty" type="text" class="form-control" id="company" value="${user.faculty}">
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="Job" class="col-md-4 col-lg-3 col-form-label">Department</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="department" type="text" class="form-control" id="Job" value="${user.department}">
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="Country" class="col-md-4 col-lg-3 col-form-label">Level</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="level" type="text" class="form-control" id="Country" value="${user.level}">
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="Address" class="col-md-4 col-lg-3 col-form-label">Matric Number</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="matNumber" type="text" class="form-control" id="Address" value="${user.matricNumber}">
                                                </div>
                                            </div>
                                            <div class="text-center">
                                                <button type="submit" class="btn btn-primary">Save Changes</button>
                                            </div>
                                        </form><!-- End Profile Edit Form -->
                                    </div>
                                    <div class="tab-pane fade pt-3" id="profile-change-password">
                                        <!-- Change Password Form -->
                                        <form action="update" method="POST">
                                            <div class="row mb-3">
                                                <label for="currentPassword" class="col-md-4 col-lg-3 col-form-label">Current Password</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="currentPassword" type="password" class="form-control" id="currentPassword">
                                                    <input hidden="" value="change-stud-password" name="criteria"/>
                                                    <input hidden="" value="${user.name}" name="studentId"/>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="newPassword" class="col-md-4 col-lg-3 col-form-label">New Password</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="newpassword" type="password" class="form-control" id="newPassword">
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">Re-enter New Password</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="renewpassword" type="password" class="form-control" id="renewPassword">
                                                </div>
                                            </div>
                                            <div class="text-center">
                                                <button type="submit" class="btn btn-primary">Change Password</button>
                                            </div>
                                        </form><!-- End Change Password Form -->
                                    </div>
                                </c:when>
                                <c:when test="${candidate.name ne null}">
                                    <div class="tab-pane fade show active profile-overview" id="profile-overview">
                                        <h5 class="card-title">Manifesto</h5>
                                        <c:if test="${candidate.manifesto eq null}">Please do Put a Manifesto</c:if>
                                        <p class="small fst-italic">${candidate.manifesto}</p>
                                        <h5 class="card-title">Profile Details</h5>
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label ">Full Name</div>
                                            <div class="col-lg-9 col-md-8">${candidate.name}</div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Position Running For:</div>
                                            <div class="col-lg-9 col-md-8">${candidate.position}</div>
                                        </div>
                                    </div>
                                    <div class="tab-pane fade profile-edit pt-3" id="profile-edit">
                                        <!-- Profile Edit Form -->
                                        <form method="POST" action="update" enctype="multipart/form-data">
                                            <div class="row mb-3">
                                                <label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Upload Profile Image</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="file" name="formFile">
                                                        <input hidden="" value="edit-candidate" name="criteria"/>
                                                        <input hidden="" value="${candidate.name}" name="canId"/>
                                                    </div>
                                                </div>
                                                <div class="row mb-3">
                                                    <label for="about" class="col-md-4 col-lg-3 col-form-label">Manifesto</label>
                                                    <div class="col-md-8 col-lg-9">
                                                        <textarea name="manifesto" class="form-control" id="about" style="height: 100px">${candidate.manifesto}</textarea>
                                                    </div>
                                                </div>
                                                <div class="text-center">
                                                    <button type="submit" class="btn btn-primary">Save Changes</button>
                                                </div>
                                            </div>
                                        </form><!-- End Profile Edit Form -->
                                    </div>
                                    <div class="tab-pane fade pt-3" id="profile-change-password">
                                        <!-- Change Password Form -->
                                        <form method="POST" action="update">
                                            <div class="row mb-3">
                                                <label for="currentPassword" class="col-md-4 col-lg-3 col-form-label">Current Password</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="password" type="password" class="form-control" >
                                                    <input name="criteria" hidden="" class="form-control" value="change-cand-password">
                                                    <input name="candName" hidden="" class="form-control" value="${candidate.name}" >
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="newPassword" class="col-md-4 col-lg-3 col-form-label">New Password</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="newpassword" type="password" class="form-control" >
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">Re-enter New Password</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="conpassword" type="password" class="form-control">
                                                </div>
                                            </div>
                                            <div class="text-center">
                                                <button type="submit" class="btn btn-primary">Change Password</button>
                                            </div>
                                        </form><!-- End Change Password Form -->
                                    </div>
                                </c:when>
                                <c:when test="${elecoadmin.username ne null}">
                                    <div class="tab-pane fade show active profile-overview" id="profile-overview">
                                        <h5 class="card-title">Profile Details</h5>
                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label ">Full Name</div>
                                            <div class="col-lg-9 col-md-8">${elecoadmin.username}</div>
                                        </div>
                                    </div>
                                    <div class="tab-pane fade profile-edit pt-3" id="profile-edit">
                                        <form method="POST" action="update" enctype="multipart/form-data">
                                            <div class="row mb-3">
                                                <label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Upload Profile Image</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <div class="col-sm-10">
                                                        <input class="form-control" type="file" name="formFile">
                                                        <input hidden="" value="edit-eleco" name="criteria"/>
                                                        <input hidden="" value="${elecoadmin.username}" name="adminId"/>
                                                    </div>
                                                </div>
                                                <div class="text-center">
                                                    <button type="submit" class="btn btn-primary">Save Changes</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="tab-pane fade pt-3" id="profile-change-password">
                                        <!-- Change Password Form -->
                                        <form action="update" method="POST">
                                            <div class="row mb-3">
                                                <label for="currentPassword" class="col-md-4 col-lg-3 col-form-label">Current Password</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="currentPassword" type="password" class="form-control" id="currentPassword">
                                                    <input hidden="" value="change-admin-password" name="criteria"/>
                                                    <input hidden="" value="${elecoadmin.username}" name="adminId"/>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="newPassword" class="col-md-4 col-lg-3 col-form-label">New Password</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="newpassword" type="password" class="form-control" id="newPassword">
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">Re-enter New Password</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="renewpassword" type="password" class="form-control" id="renewPassword">
                                                </div>
                                            </div>
                                            <div class="text-center">
                                                <button type="submit" class="btn btn-primary">Change Password</button>
                                            </div>
                                        </form><!-- End Change Password Form -->
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    ${elecoadmin.username}
                                </c:otherwise>
                            </c:choose>
                        </div><!-- End Bordered Tabs -->
                    </div>
                </div>
            </div>
        </div>
    </section>
</main><!-- End #main -->
