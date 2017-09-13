<!DOCTYPE html>
<%@page import="com.info.model.ModeratorModel"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
  <!-- Site made with Mobirise Website Builder v3.12.1, https://mobirise.com -->
  <%@include file="fileInclude.jsp" %>
  
</head>
<body>
<%@include file="navbar.jsp" %>



<div class="addModeratorDiv" style="margin-top: 130px;">
	<div class="row">
		<div class="col-lg-6 col-lg-offset-3" style="border: solid 1px #ccc; ">
			<form class="form-horizontal" action="<%=application.getContextPath() %>/AddUser" method="post">
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">Name </label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control"  placeholder="name" name="name"  required="required"><br>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">Username</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control"  placeholder="username" name="username" required="required"><br>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control"  placeholder="Password" name="password" required="required"><br>
			    </div>
			  </div><br>
			  
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Save</button>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</div>

  <input name="animation" type="hidden">
  </body>
</html>