<!DOCTYPE html>
<%@page import="com.info.model.SmsModel"%>
<%@page import="com.info.model.userModel"%>
<%@page import="com.info.model.ModeratorModel"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
  <%@include file="fileInclude.jsp"%>
  
  <style type="text/css">
  	thead th{text-align: center;}
  </style>
  
</head>
<body class="container">

<%@include file="navbar.jsp" %>


<section class="mbr-section" id="form1-s" style="background-color: rgb(255, 255, 255); padding-top: 120px; padding-bottom: 120px;">

<nav class="navbar"><a href="wel.jsp"><button class="btn pull-right">Logout</button></a> </nav>

<div class="addModeratorDiv"  style="padding: 10px;">
		<div class="col-lg-4" style="border: solid 1px #ccc; ">
			<form class="form-horizontal" action="<%=application.getContextPath() %>/AddSms" method="post">
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-4 control-label">Select User </label>
			    <div class="col-sm-8">
			    	<select class="form-control" name="userid">
			    		 
			    		<% int countu=1;
  					 ArrayList<userModel> userDb = (ArrayList<userModel>)session.getAttribute("userDb");
                 	
  					if(userDb!=null)
                   		for(userModel showUs : userDb)
                       	{
                       %>
                           <option value="<%=showUs.getId()%>"><%=showUs.getName()%></option>
                           
                      <%}
                   	else
            			out.println("No Record!!!");
                      %>
			    	</select><br>
			     </div>
			  </div>
			  
			  
			  
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-4 control-label">message</label>
			    <div class="col-sm-8">
			    	<textarea rows="4" cols="" class="form-control" name="sms"></textarea><br>
			     </div>
			  </div><br>
			  
			  <div class="form-group">
			    <div class="col-sm-offset-4 col-sm-10">
			      <button type="submit" class="btn btn-default">Send</button>
			    </div>
			  </div>
			</form>
		</div>
		
		
		<div class="col-lg-4">
			<table class="table-bordered table-condensed table-hover" style="width: 100%!important; ">
				<thead style=" color: white; background-color: #ccc;">
					<tr >
						<th colspan="2">SEND</th>
					</tr>
					<tr >
						<th >TO</th>
						<th >SMS</th>
					</tr>
				</thead>
				<tbody>
					<%
					String userID=(String)session.getAttribute("userid");
  					 ArrayList<SmsModel> smsDb = (ArrayList<SmsModel>)session.getAttribute("smsDb");
                 	
  					if(smsDb!=null)
                   		for(SmsModel show : smsDb)
                       	{
                   			for(userModel showUs : userDb)
                           	{
                           	String newUserid=showUs.getId();
                   			String sender=show.getSender();
                   			String reciver=show.getReciver();
                   			
                   			System.out.println(" userid is : "+userID+" sender id is : "+sender+" recive id is : "+reciver);
                       %>
                           <tr>
                           		
                           		<%
                           		if(newUserid.equals(sender))
                           		{
                           		if(userID.equals(sender)){ %>
                           		<td>
                           			<%=showUs.getName()%>
                           		</td>
                           		<td>
                           			<%=show.getSms()%>
                           		</td>
                           		<%}}else{ %>
                           		<% }%>
                           </tr>
                      <%}}
                   	else
            			out.println("No Record!!!");
                      %>
				</tbody>
				
			</table>
		</div>
		
		
		
		<div class="col-lg-4">
			<table class="table-bordered table-condensed table-hover" style="width: 100%!important; ">
				<thead style=" color: white; background-color: #ccc;">
					<tr >
						<th colspan="2">INBOX</th>
					</tr>
					<tr >
						<th >FROM</th>
						<th >SMS</th>
					</tr>
				</thead>
				<tbody>
					<%
  					if(smsDb!=null)
                   		for(SmsModel show : smsDb)
                       	{
                   			for(userModel showUs : userDb)
                           	{
                           	String newUserid=showUs.getId();
                   			String sender=show.getSender();
                   			String reciver=show.getReciver();
                   			
                   			System.out.println(" userid is : "+userID+" sender id is : "+sender+" recive id is : "+reciver);
                       %>
                           <tr>
                           		<%
                           		if(newUserid.equals(sender))
                           		{
                           		if(userID.equals(reciver)){ %>
                           		<td>
                           			 <%=showUs.getName()%> 
                           		</td>
                           		<td>
                           			<%=show.getSms()%>
                           		</td>
                           		<%}}else{ %>
                           		<% }%>
                           		
                           		
                           </tr>
                      <%}}
                   	else
            			out.println("No Record!!!");
                      %>
				</tbody>
	</div>

</section>
  <input name="animation" type="hidden">
  </body>
</html>