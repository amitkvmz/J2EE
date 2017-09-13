<!DOCTYPE html>
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
	<div class="col-lg-12">
		<div class="well well-sm">
		
			<button class="btn btn-sm" id="addbtn">Add New Article</button>
			<!-- <button class="btn btn-sm" id="viewbtn">View Article</button>  -->
			<a href="ForwardChatPage">
				<button class="btn btn-sm">Chat With User</button>
			</a>
			<a href="wel.jsp"><button class="btn btn-info" style="align: right">Logout</button></a> 		
		</div>
	</div>
</div><br>

<div class="addarticel" id="addarticel" style="display: none;">
	<div class="row">
		<div class="col-lg-6 col-lg-offset-3" style="border: solid 1px #ccc; ">
			<form accept-charset="UTF-8" role="form" enctype="multipart/form-data" class="form-horizontal" action="<%=application.getContextPath()%>/AddPost" method="post">
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">Type </label>
			    <div class="col-sm-10">
			   		<select class="mbri-down form-control form-control"  name="articlCat"  required="required">
               			<option>Articles</option>
               			<option>Technical</option>
               			<option>Photography</option>
               			<option>Paintings</option>
               		</select>
               		<br>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">Image</label>
			    <div class="col-sm-10">
			      <input type="file" class="form-control"   name="image" ><br>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">Text</label>
			    <div class="col-sm-10">
			    	<textarea rows="4" class="form-control"  cols="" name="text"></textarea><br>
			     </div>
			  </div><br>
			  
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Post</button>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</div>


  <div class="postView" id="postView" style="display: none;">
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
  					<% int counta=1;
                                	 ArrayList<PostModel> postDb = (ArrayList<PostModel>)session.getAttribute("postDb");
                                	if(postDb!=null)
                                		for(PostModel show : postDb)
                                    	{ 
                                    %>
                                    <tr>
                                        <td><%=counta++ %></td>
                                        <td><%=show.getType()%></td>
                                        <td><%=show.getText()%></td>
                                         <td><%=show.getStatus()%></td>
                                         <td>
                                        	<a href="<%=application.getContextPath()%>/RomevePostByUser?ID=<%=show.getId()%>">
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
  

  <input name="animation" type="hidden">
  
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#addbtn").click(function(){
  			$("#addarticel").show("slow");
  			$("#postView").hide("slow");
  		});
  		
  		$("#viewbtn").click(function(){
  			$("#addarticel").hide("slow");
  			$("#postView").show("slow");
  		});
  	});
  </script>
  </body>
</html>