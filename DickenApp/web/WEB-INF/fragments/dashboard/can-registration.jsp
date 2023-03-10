<%--
    Document   : registration-body
    Created on : Feb 25, 2023, 1:52:57 PM
    Author     : BLAZE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<main>
    <div class="container">

        <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

                        <div class="d-flex justify-content-center py-4">
                            <a href="index.jsp" class="logo d-flex align-items-center w-auto">
                                <img src="assets/img/logo.png" alt="">
                                <span class="d-none d-lg-block">NiceAdmin</span>
                            </a>
                        </div><!-- End Logo -->

                        <div class="card mb-3">

                            <div class="card-body">

                                <div class="pt-4 pb-2">
                                    <h5 class="card-title text-center pb-0 fs-4">Create an Account</h5>
                                    <p class="text-center small">Enter your personal details to create account</p>
                                </div>

                                <form class="row g-3 needs-validation" novalidate id="signupCan">
                                    <div class="col-12">
                                        <label for="yourName" class="form-label">Your Name</label>
                                        <input type="text" id="name" class="form-control" id="yourName" required>
                                        <div class="invalid-feedback">Please, enter your full id!</div>
                                    </div>
                                    <div class="col-12">
                                        <label for="yourPassword" class="form-label">Password</label>
                                        <input type="password" id="password" class="form-control" id="yourPassword" required>
                                        <div class="invalid-feedback">Please enter your password!</div>
                                    </div>
                                    <label for="position" class="form-label">Select Position</label>
                                    <div class="col-12">
                                        <select class="form-select" aria-label="Default select example" id="position">
                                            <option value="president" selected>President</option>
                                            <option value="vp">Vice President</option>
                                            <option value="sg">Secretary General</option>
                                            <option value="dos">Director of Socials</option>
                                            <option value="dosp">Director of Sports</option>
                                            <option value="dow">Dirrector of Welfare</option>
                                            <option value="doi">Director of Information</option>
                                            <option value="fs">Financial Secretary</option>
                                        </select>
                                    </div>
                                    <div class="col-12">
                                        <label for="yourUsername" class="form-label">Pin</label>
                                        <div class="input-group has-validation">
                                            <input type="text" id="authPin" class="form-control"  required>
                                            <div class="invalid-feedback">Please enter a valid registration pin .</div>
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <div class="form-check">
                                            <input class="form-check-input" name="terms" type="checkbox" value="" id="acceptTerms" required>
                                            <label class="form-check-label" for="acceptTerms">I agree and accept the <a href="#">terms and conditions</a></label>
                                            <div class="invalid-feedback">You must agree before submitting.</div>
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <button class="btn btn-primary w-100" type="submit">Create Account</button>
                                    </div>
                                    <div class="col-12">
                                        <p class="small mb-0">Already have an account? <a href="pages-login.html">Log in</a></p>
                                    </div>
                                </form>
                            </div>
                        </div>

                        <div class="credits">
                            <!-- All the links in the footer should remain intact. -->
                            <!-- You can delete the links only if you purchased the pro version. -->
                            <!-- Licensing information: https://bootstrapmade.com/license/ -->
                            <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
                            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                        </div>

                    </div>
                </div>
            </div>

        </section>

    </div>
</main>

<!-- End #main -->