import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class UserProcess extends HttpServlet
{
    public void service(HttpServletRequest sreq, HttpServletResponse sres)
{
    PrintWriter out=null;
    try
    {
        sres.setContentType("text/html");
        out=sres.getWriter();
        String userid=sreq.getParameter("userid");
        int uid = Integer.parseInt("userid");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","amit","amit");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM USER_INFO WHERE userid="+uid);
        if(rs.next())
        {
            RequestDispatcher rd=sreq.getRequestDispatcher("ShowUser");
            rd.forward(sreq,sres);
        }
        else
        sres.sendRedirect("index.html");
        con.close();
    }
    catch(Exception e)
    {
        out.println(e);
    }
    }
}
