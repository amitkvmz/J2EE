import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class RegisterUser extends HttpServlet
{
    public void service(HttpServletRequest sreq, HttpServletResponse sres)
    {
        PrintWriter out=null;
        try
        {
            sres.setContentType("text/html");
            out=sres.getWriter();
            String name=sreq.getParameter("name");
            String phone=sreq.getParameter("phone");
            String age=sreq.getParameter("age");
            int a= Integer.parseInt(age);
            String email=sreq.getParameter("email");

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","amit","amit");
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from users_info where email='" + email + "'");
            int duplicate=0;
            while(rs.next())
            {
                duplicate++;
            }
            if(duplicate==0)
            {
                st.executeUpdate("insert into users_info values(default+'"+name+"', '"+phone+"', '"+a+"','"+email+"')");  
                sres.sendRedirect("registersuccess.html");   
            }
            else
            sres.sendRedirect("registererror.html");
        }
        catch(Exception e)
        {          
            out.println(e);               
        }    
    }
}
