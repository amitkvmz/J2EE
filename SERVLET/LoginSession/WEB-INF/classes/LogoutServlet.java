import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LogoutServlet extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res)
    {
        PrintWriter out= null;
        res.setContentType("text/html");
        try
        {
            out=res.getWriter();
            //Cookie ck[]=res.getCookies();
            //ck[0]=null;
            //ck[1]=null;
            Cookie ck=new Cookie("name","");
            ck.setMaxAge(0);
            res.addCookie(ck);
            res.sendRedirect("logout.html");
        }
        catch(Exception e)
        {
            out.print(e);
        }
    } 
}