import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
public class ServletContextEx extends HttpServlet{
    ServletContext ctx;
    ServletConfig con;
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
        ctx=getServletContext();
        con=getServletConfig();
        String s1=con.getInitParameter("age");
        String s2=ctx.getInitParameter("email");
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("<html><body>");
        out.println("Hye your age ="+s1);
        out.println("and your email is "+s2+"using context");
        out.println("</html></body>");       
    }
}