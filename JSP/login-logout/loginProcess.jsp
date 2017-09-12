<html>
    <%@ page import="java.sql.*"%>
    <body>
        <center>
            <%
            String id=request.getParameter("n");
            String pass=request.getParameter("p");
            Statement st=(Statement)application.getAttribute("stmt");
            ResultSet rs=st.executeQuery("SELECT * FROM login_info WHERE uid='+id+' AND pass='+pass+'");
            if(rs.next())
            {
                String n=rs.getString(3);
                session.setAttribute("name",n);
                response.sendRedirect("about.jsp");
            }
            else
            {
            %>
            <%@ include file="login.html" %>
            <br/>Wrong Entries !!!<br/>
            <%
            }
            %>
        </center>
    </body>
</html>
