import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AboutServlet extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res)
    {
        PrintWriter out = null;
        try
        {
            res.setContentType("text/html");
            out=res.getWriter();
            Cookie ck[]=req.getCookies();
            if(ck!=null)
            {
                String id=ck[0].getValue();
                out.print("<br><br>Welcome,"+id);
               /* out.print("<form action='LS2'>");
                out.print("<input type='submit' value='Logout'");
                out.print("</form>");
                */
                out.print("<a href='LS2'>Logout</a>");
            }
            else
            {
                res.sendRedirect("loginSessionError.html");
            }
            out.close();
        }
        catch(Exception ex)
        {
            out.println(ex);
        }
    }
}