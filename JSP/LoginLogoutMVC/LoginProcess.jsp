<%@ page errorPage="ExceptionPage.jsp" %>
<%
    int u=Integer.parseInt(request.getParameter("n"));
    String p=request.getParameter("p");
%>
<jsp:useBean id="t1" class="bean.LoginBean" scope="session"/>
<jsp:setProperty name="t1" property="user" value="<%=u%>"/>
<jsp:setProperty name="t1" property="pass" value="<%=p%>"/>
        <%
            if(t1.execute())
            {
                session.setAttribute("userid",u);
                response.sendRedirect("About.jsp");
            }
            else
            {
                session.setAttribute("msg","Wrong ID or Password <br/>");
                response.sendRedirect("Login.jsp");
            }
        %>