import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SecondServlet extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res)
    {
        PrintWriter out = null;
        try
        {
            res.setContentType("text/html");
            out=res.getWriter();
            Cookie ck[]=req.getCookies();
            out.print("Your Name"+ck[0].getValue());
            out.print("your Password"+ck[1].getValue());
            out.close();
        }
        catch(Exception ex)
        {
            out.println(ex);
        }
    }
}