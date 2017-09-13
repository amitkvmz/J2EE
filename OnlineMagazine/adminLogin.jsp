<!DOCTYPE html>
<html>
<head>
  <!-- Site made with Mobirise Website Builder v3.12.1, https://mobirise.com -->
  <%@include file="fileInclude.jsp" %>
  
</head>
<body>
<%@include file="navbar.jsp" %>

<section class="mbr-section" id="form1-s" style="background-color: rgb(255, 255, 255); padding-top: 120px; padding-bottom: 120px;">
    
    <div class="mbr-section mbr-section__container mbr-section__container--middle">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 text-xs-center">
                    <h3 class="mbr-section-title display-2">Admin Login</h3>
                    <small class="mbr-section-subtitle">Please enter your details.</small>
                </div>
            </div>
        </div>
    </div>
    <div class="mbr-section mbr-section-nopadding">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-lg-10 col-lg-offset-1" data-form-type="formoid">


                    <div data-form-alert="true">
                        <div hidden="" data-form-alert-success="true" class="alert alert-form alert-success text-xs-center">Thanks for filling out form!</div>
                    </div>


                    <form action="AdminLogin" method="post" data-form-title="Login Here">

                        <input type="hidden" value="L9+2COdh8ttPrazP480t7Uf3t2L15yGRWQtbkeA6+DAM3qZIN28dV5q0Zzsv9C524SnTrWwfobhyyIEPDtXHO9XnXgb/4Ob1UOjgiW94lM1hxQz5WXDR7WqepawwIpzK" data-form-email="true">

                        <div class="row row-sm-offset">

                            <div class="col-xs-12 col-md-6 col-lg-offset-3">
                                <div class="form-group">
                                    <label class="form-control-label" for="form1-s-name">User Name <span class="form-asterisk"></span></label>
                                    <input type="text" class="form-control" name="username" data-form-field="Name" id="form1-s-name" required="required">
                                </div>
                            </div>

                            <div class="col-xs-12 col-md-6 col-lg-offset-3">
                                <div class="form-group">
                                    <label class="form-control-label" for="form1-s-email">Password <span class="form-asterisk"></span></label>
                                    <input type="password" class="form-control" name="password" data-form-field="Email" id="form1-s-email" required="required">
                                </div>
                            </div>
                        </div>
                        <div><button type="submit" class="btn btn-primary col-lg-offset-3">Login</button></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>




  
  
  <input name="animation" type="hidden">
  </body>
</html>