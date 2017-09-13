<!DOCTYPE html>
<%@page import="com.info.model.userModel"%>
<%@page import="com.info.model.PostModel"%>
<%@page import="com.info.model.ModeratorModel"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
  <!-- Site made with Mobirise Website Builder v3.12.1, https://mobirise.com -->
  <%@include file="fileInclude.jsp" %>
  
</head>
<body>
<%@include file="navbar.jsp" %>

<div class="row container-fulid" style="margin-top: 130px; border-bottom: 1px solid #ccc; margin-left: 0px; margin-right: 0px;">
	<div class="col-lg-12 ">
		<div class="well well-sm">
			<button class="btn btn-sm" id="addmoderatoBtn">Add Moderator</button>
			<button class="btn btn-sm" id="viewmoderatoBtn">View Moderator</button>
			<button class="btn btn-sm" id="adduserBtn">Add User</button>
			<button class="btn btn-sm" id="removeUserBtn">Remove User</button>
			<button class="btn btn-sm" id="verfyPostBtn"> Verify Articles</button>
			<button class="btn btn-sm" id="removePostBtn"> Remove Articles</button>
			&nbsp&nbsp &nbsp <a href="wel.jsp"><button class="btn btn-info">Logout Admin</button></a>
		</div>
	</div>
</div><br>

<div class="addModeratorDiv" style="display: none;" id="addModeratorDiv">
	<div class="row">
		<div class="col-lg-6 col-lg-offset-3" style="border: solid 1px #ccc; ">
			<form class="form-horizontal" action="<%=application.getContextPath() %>/AddModerator" method="post">
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">Name </label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control"  placeholder="name" name="modName"  required="required"><br>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">Username</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control"  placeholder="username" name="modUsername" required="required"><br>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control"  placeholder="Password" name="modPassword" required="required"><br>
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

  
  
  
  
  
  
  
  
  <div class="modView" style="display: none;" id="modView">
  	<div class="row">
  		<div class="col-lg-6 col-lg-offset-3" style="border: solid 1px #ccc; ">
  			<table class="table-bordered table-condensed" style="min-width: 100%!important; " >
  				<thead>
  					<tr>
  						<th>#</th>
  						<th>Name</th>
  						<th>UserName</th>
  						<th>PAssword</th>
  						<th>Action</th>
  					</tr>
  				</thead>
  				<tbody>
  					<% int counta=1;
                                	 ArrayList<ModeratorModel> orderDb = (ArrayList<ModeratorModel>)session.getAttribute("modDb");
                                	if(orderDb!=null)
                                		for(ModeratorModel show : orderDb)
                                    	{ 
                                    %>
                                    <tr>
                                        <td><%=counta++ %></td>
                                        <td><%=show.getName() %></td>
                                        <td><%=show.getUsername()%></td>
                                         <td><%=show.getPassword()%></td>
                                         <td>
                                        	<a href="<%=application.getContextPath()%>/RomeveModerator?modID=<%=show.getPassword()%>">
                                            	<button type="button" class="btn btn-danger btn-xs">remove</button>
                                        	</a>
                                        </td> 
                                    </tr>
                                   <%} 
                                	else
	                        			out.println("No Record!!!");
                                   %>
  				</tbody>
  			</table>
  		</div>
  	</div>
  </div>
  
  
  
  
  
  
  
  <div class="removePostView" id="removePostView" style="display: none;">
  	<div class="row" ">
  		<div class="col-lg-10 col-lg-offset-1" >
  			<table class="table-bordered table-condensed" style="min-width: 100%!important; " >
  				<thead style="background-color: #ccc; color: white;">
  					<tr>
  						<th>#</th>
  						<th>Type</th>
  						<th>Text</th>
  						<th>Status</th>
  						<th>Action</th>
  					</tr>
  				</thead>
  				<tbody>
  					<% int count=1;
                                	 ArrayList<PostModel> postDb = (ArrayList<PostModel>)session.getAttribute("postDb");
                                	if(postDb!=null)
                                		for(PostModel show : postDb)
                                    	{ 
                                    %>
                                    <tr>
                                        <td><%=count++ %></td>
                                        <td><%=show.getType()%></td>
                                        <td><%=show.getText()%></td>
                                         <td><%=show.getStatus()%></td>
                                         <td>
                                        	<a href="<%=application.getContextPath()%>/RemovePostByAdmin?ID=<%=show.getId()%>">
                                            	<button type="button" class="btn btn-danger btn-xs pull-right">remove</button>
                                        	</a>
                                        </td> 
                                    </tr>
                                   <%} 
                                	else
	                        			out.println("No Record!!!");
                                   %>
  				</tbody>
  			</table>
  		</div>
  	</div>
  </div>
  
  
  
  
  
  
  
  
  <div class="verfyPostView" id="verfyPostView" style="display: none;">
  	<div class="row">
  		<div class="col-lg-10 col-lg-offset-1" >
  			<table class="table-bordered table-condensed" style="min-width: 100%!important; " >
  				<thead style="background-color: #ccc; color: white;">
  					<tr>
  						<th>#</th>
  						<th>Type</th>
  						<th>Text</th>
  						<th>Status</th>
  						<th>Action</th>
  					</tr>
  				</thead>
  				<tbody>
  					<% int countr=1;
                   	if(postDb!=null)
                   		for(PostModel show : postDb)
                       	{ 
                   			String status=show.getStatus();
                   			if(status.equalsIgnoreCase("pending"))
                   			{
                       %>
                       <tr>
                           <td><%=countr++ %></td>
                           <td><%=show.getType()%></td>
                           <td><%=show.getText()%></td>
                            <td><%=show.getStatus()%></td>
                            <td>
                           	<a href="<%=application.getContextPath()%>/verfyPostByAdmin?ID=<%=show.getId()%>">
                               	<button type="button" class="btn btn-danger btn-xs pull-right">Post Live</button>
                           	</a>
                           </td> 
                       </tr>
                      <%} }
                   	else
            			out.println("No Record!!!");
                      %>
  				</tbody>
  			</table>
  		</div>
  	</div>
  </div>
  
  
  
  <!-- amit section -->
  
  
  <div class="addUserDiv" id="addUserDiv" style="display: none;"">
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

  
  
  
  
  
  
  <div class="removeUser" id="removeUser" style="display: none;">
  	<div class="row" ">
  		<div class="col-lg-10 col-lg-offset-1" >
  			<table class="table-bordered table-condensed" style="min-width: 100%!important; " >
  				<thead style="background-color: #ccc; color: white;">
  					<tr>
  						<th>#</th>
  						<th>Type</th>
  						<th>Text</th>
  						<th>Status</th>
  						<th>Action</th>
  					</tr>
  				</thead>
  				<tbody>
  					<% int countu=1;
  					 ArrayList<userModel> userDb = (ArrayList<userModel>)session.getAttribute("userDb");
                 	
  					if(userDb!=null)
                   		for(userModel show : userDb)
                       	{
                       %>
                       <tr>
                           <td><%=countu++ %></td>
                           <td><%=show.getName()%></td>
                           <td><%=show.getUsername()%></td>
                            <td><%=show.getPassword()%></td>
                            <td>
                           	<a href="<%=application.getContextPath()%>/RemoveUser?ID=<%=show.getId()%>">
                               	<button type="button" class="btn btn-danger btn-xs pull-right">remove</button>
                           	</a>
                           </td> 
                       </tr>
                      <%}
                   	else
            			out.println("No Record!!!");
                      %>
  				</tbody>
  			</table>
  		</div>
  	</div>
  </div>
  
  
  
  
  
 
  
  
  
  
  
  

    <script type="text/javascript">
  	$(document).ready(function(){
  		$("#viewmoderatoBtn").click(function(){
  			$("#modView").show("slow");
  			$("#addModeratorDiv").hide("slow");
  			$("#addUserDiv").hide("slow");
  			$("#removeUser").hide("slow");
  			
  			$("#removePostView").hide("slow");
  			$("#verfyPostView").hide("slow");
  		});
  		
  		
  		$("#addmoderatoBtn").click(function(){
  			$("#addModeratorDiv").show("slow");
  			$("#addUserDiv").hide("slow");
  			
  			
  			$("#removeUser").hide("slow");
  			$("#removePostView").hide("slow");
  			$("#verfyPostView").hide("slow");
  			$("#modView").hide("slow");
  		});
  		
  		// amit section
  			$("#adduserBtn").click(function(){
  			$("#addUserDiv").show("slow");
  			$("#addModeratorDiv").hide("slow");
  			
  			
  			
  			$("#removeUser").hide("slow");
  			$("#removePostView").hide("slow");
  			$("#verfyPostView").hide("slow");
  			$("#modView").hide("slow");
  		});
  		
  		
  		$("#removeUserBtn").click(function(){
  			$("#removeUser").show("slow");
  			$("#addUserDiv").hide("slow");
  			
  			$("#removePostView").hide("slow");
  			$("#verfyPostView").hide("slow");
  			$("#addModeratorDiv").hide("slow");
  			$("#modView").hide("slow");
  		});
  		
  		
  		$("#verfyPostBtn").click(function(){
  			$("#removeUser").hide("slow");
  			$("#addUserDiv").hide("slow");
  			$("#removePostView").hide("slow");
  			$("#verfyPostView").show("slow");
  			$("#addModeratorDiv").hide("slow");
  			$("#modView").hide("slow");
  		});
  		
  		$("#removePostBtn").click(function(){
  			$("#removeUser").hide("slow");
  			$("#addUserDiv").hide("slow");
  			$("#verfyPostView").hide("slow");
  			$("#removePostView").show("slow");
  			$("#addModeratorDiv").hide("slow");
  			$("#modView").hide("slow");
  		});
  	});
  </script>
  
  <input name="animation" type="hidden">
  </body>
</html>