<html>
    <body>
        <center>
            <h1> My Login-Logout App </h1>
            <form action="LoginProcess.jsp" method="POST">
                User Id: <input type="text" name ="n" required/>
                Password:<input type="password" name="p" required/>
                <input type="submit" value="Submit"/>
                <input type="reset" value="clear"/>
            </form>
            
            <%
            String m=(String)session.getAttribute("msg");
            if(m!=null)
            {
            %>
            <b><%= m%></b>
            <%
            }
            %>
        </center>
    </body>
</html>