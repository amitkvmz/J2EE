<%@ page import="java.sql.*" %>
<%@ page errorPage="ExceptionPage.jsp" %>
<html>
    <head></head>
        <body>
            <%
            Integer n=(Integer)session.getAttribute("userid");
            if(n!=null)
            {
            %>
            <jsp:useBean id="t1" class="bean.LoginBean" scope="session"/>
            <%
            ResultSet rs=t1.getRs();
            %>
            <h1> My LoginLogoutMVC App</h1>
            Welcome <b> <%= rs.getString(2) %></b></hr>
            <a href="Logout.jsp">Logout</a><br/><br/>
            User ID : <b><%= n %></b><br/><br/>
            Phone   : <%= rs.getString(3) %><br/><br/>
            Age     : <%= rs.getString(4) %><br/><br/>
            Email   : <%= rs.getString(5) %><br/><br/>
            <% 
            }
            else
            {
                session.setAttribute("msg","plz Login First <br/>");
                response.sendRedirect("Login.jsp");
            }
            %>
    </body>
</html>