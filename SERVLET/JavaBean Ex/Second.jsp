<html>
    <body>
        <jsp:useBean id="t1" class="ra.MyBean" scope="session"/>
            you have entered below details </br>
            <jsp:getProperty property="username" name="t1"/></br>
            <jsp:getProperty property="password" name="t1"/></br>
            <jsp:getProperty property="age" name="t1" /></br>
    </body>
</html>
