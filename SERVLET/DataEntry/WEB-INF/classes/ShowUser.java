import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class ShowUser extends HttpServlet
{
    public void service(HttpServletRequest sreq, HttpServletResponse sres)
    {
        PrintWriter out=null;
        try
        {
            sres.setContentType("text/html");
            out=sres.getWriter();
            String userid=sreq.getParameter("userid");
            int uid=Integer.parseInt("userid");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","amit","amit");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM USER_INFO WHERE userid="+uid);
            while(rs.next())
            {
            out.println("User ID: <b> "+rs.getInt(1)+"</b></br></br>");
            out.println("Name: <b>"+rs.getString(2)+"</b></br></br>");
            out.println("Phone : <b>"+rs.getInt(3)+"</b></br></br>");
            out.println("Age : <b>"+rs.getInt(4)+"</b></br></br>");
            out.println("Email : <b>"+rs.getString(5)+"</b></br></br>");
            }
            	// Counter Program using ServletContext

                ServletContext ctx = getServletContext();
				Integer c = (Integer)ctx.getAttribute("count");
				if (c==null)
				 {
				 	c=1;
				 	ctx.setAttribute("count",c);
				 }
				 else
				 {
				 	c++;
				 	ctx.setAttribute("count",c);

				 } 
				out.println("<center><font color=red><h3>You are the "+c+" Visitor to our Website.");
				out.println("</h3></font><a href='index.html'>Back</a></center></body></html>");
				con.close();

        }
        catch(Exception ex)
        {
            out.println(ex);
        }
    }
}