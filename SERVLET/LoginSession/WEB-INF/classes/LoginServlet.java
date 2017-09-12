import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
    {
        PrintWriter out=null;
        try
        {
            res.setContentType("text/html");
            out=res.getWriter();
            String n1=req.getParameter("u");
            String n2=req.getParameter("p");
            if(n2.equals("incapp"))
            {
                Cookie ck1=new Cookie("name",n1);
                res.addCookie(ck1);
                res.sendRedirect("AS");   
            }
            else
            {
                res.sendRedirect("loginError.html");
            }
            out.close();
        }
        catch(Exception ex)
        {
            out.println(ex);
        }
    }
}