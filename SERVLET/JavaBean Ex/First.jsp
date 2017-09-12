<html>
    <body>
        <%
        String n=request.getParameter("uname");
        String p=request.getParameter("pass");
        String a=request.getParameter("age");
        %>
        <jsp:useBean id="t1" class="ra.MyBean" scope="session">
            <jsp:setProperty name="t1" property="username" value="<%= n %>"/>
                <jsp:setProperty name="t1" property="password" value="<%= p %>" />
                    <jsp:setProperty name="t1" property="age" value="<%= Integer.parseInt(a) %>" />
        </jsp:useBean>
        <a href="Second.jsp">call second JSP</a>
    </body>
</html>