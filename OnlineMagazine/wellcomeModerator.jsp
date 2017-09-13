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





  
  
  
  
  
  
  <div class="verfyPostView" id="verfyPostView" style=" margin-top: 130px;">
  	<div class="row">
  		<div class="col-lg-10 col-lg-offset-1" >
  		
  		<a href="wel.jsp"><button class="btn btn-info pull-right">Logout</button></a>
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
  					 ArrayList<PostModel> postDb = (ArrayList<PostModel>)session.getAttribute("postDb");
                 	
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
                           	<a href="<%=application.getContextPath()%>/VerfyByModerator?ID=<%=show.getId()%>">
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
  
  

  
  
  
  
  
 
  
  
  
  
  
  


  
  <input name="animation" type="hidden">
  </body>
</html>