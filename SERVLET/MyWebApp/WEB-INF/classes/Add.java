import java.io.*;
import javax.servlet.*;
public class Add implements Servlet{
    public void init(ServletConfig sc) {
    }
    public void service(ServletRequest sreq,ServletResponse sres) {
        PrintWriter out=null;
        try{
            String s1=sreq.getParameter("num1");
            String s2=sreq.getParameter("num2");
            int n1=Integer.parseInt(s1);
            int n2=Integer.parseInt(s2);
            int n=n1+n2;
            sres.setContentType("text/html");
            out=sres.getWriter();
            out.println("<html><body>");
            out.println("<h1>My First Web Application</h1>");
            out.println("Addition of <b>"+n1+"</b> = <b>"+n+"</b>");
            out.println("</body></html>");
        }
        catch(Exception ex){
            out.println(ex);
        }
    }
    public void destroy () {
    }
    public ServletConfig getServletConfig(){
        return null;
    }
    public String getServletInfo(){
        return null;
    }
    }
