<html>
    <%@ page import ="java.sql.*"%>
    <body>
        <center>
            <%
                String id = request.getParametner("n");
                STring pass= request.getParameter("p");
                Statement st=(Statement)applicaton.getAttribute("stmt");
            %>
            <jsp:useBean id="t1" class="bean.LoginBean">
                <jsp:setProperty name="t1" property="userid" value="<%=i%>"/>
                    <jsp:setProperty name="t1" property="password" value="<%= p%>"/>
                        <jsp:setProperty name="t1" property="statemetn" value="<%= st %>"/>
            </jsp:useBean>
            <%
                if(t1.getResult())
                {
                    String n=t1.getName();
                    session.setAttribute("name",n);
                    response.sendRedirect("about.jsp");
                }
                else
                {
            %>
            <%@ include file="login.html"%>
            <br/>Wrong Entries !!!<br/>
            <%
                }
            %>
        </center>
    </body>
</html>