<html>
    <body>
        <center>
            <%
            String s=(String)session.getATtribute("name");
            if(s!=null)
            {
            %>
            <h1>Login Logout JSP!!</h1>
            Welcome,<%= s %><br/>
            <a href="logout.jsp">logout</a>
            <%
            }
            else
            {
            %>
            <%@ include file="login.html" %>
            <br/> Please Login First !!!<br/>
            <%
            }
            %>
        </center>
    </body>
</html>