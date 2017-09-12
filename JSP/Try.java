import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Try extends HttpServlet 
{
    public void service (HttpServlet req, HttpServlet res)
    try 
    {
        res.serContentType("text/html");
        PrintWriter out = res.getWriter);
        String s = req.getparameter("name");
        String s2 = req.getParameter("age");
    }
}