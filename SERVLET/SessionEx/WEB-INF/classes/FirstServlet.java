import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet
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
            out.print("Hello"+n1);
            out.print("your Password is "+n2);
            Cookie ck1=new Cookie("name",n1);
            Cookie ck2= new Cookie("Password",n2);
            res.addCookie(ck1);
            res.addCookie(ck2);
            out.print("<form action='s2'>");
            out.print("<input type='submit'' value='Go'>");
            out.close();
        }
        catch(Exception ex)
        {
            out.println(ex);
        }
    }
}