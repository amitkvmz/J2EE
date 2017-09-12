import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class HitCounter extends HttpServlet
{
    public void service(HttpServletRequest sreq, HttpServletResponse sres) throws ServletException,IOException
    {
        sres.setContentType("text/html");
        PrintWriter out= sres.getWriter();
        ServletContext ctx=getServletContext();
        Integer count = (Integer)ctx.getAttribute("count");
        if(count==null)
        {
            count=new Integer(0);
        }
        count=new Integer(count.intValue()+1);
        ctx.setAttribute("count",count);
        out.println("count.intValue");
    }
}