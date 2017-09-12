import javax.servlet.*;
import java.sql.*;
public class ListenerEx implements ServletContextListener
{
    public void contextInitialized(ServletContextEvent event)
    {
        try
        {
            Class.forName("sun.jdbc.odbc.jdbcOdbcDriver");
            Connection con=DriverManager.getConnection("jdbc:odbc:empDSN");
            //storing connection object as an attribute  in ServletContext
            ServletContext ctx=event.getServletContext();
            ctx.setAttribute("dbcCon",con);
            Statement s=con.createStatement();
            ctx.setAttribute("stmt",s);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void contextDestroyed(ServletContextEvent e)
    {

    }
}