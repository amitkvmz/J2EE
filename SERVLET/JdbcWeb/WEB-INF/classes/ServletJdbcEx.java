import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class ServletJdbcEx extends HttpServlet{
    public void service(HttpServletRequest sreq, HttpServletResponse sres){
    PrintWriter out=null;
    try{
        sres.setContentType("text/html");
        out=sres.getWriter();
        String s1=sreq.getParameter("user");
        int n=Integer.parseInt(s1);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","amit","amit");
        Statement st=con.createStatement();
        ResultSet rs= st.executeQuery("select * from user_info where userid="+n);
        out.println("<html><body>");
        out.println("<h1>My jdbc webAPp</h1>");
        if(rs.next()) {
            out.println("User ID: <b> "+rs.getString(1)+"</b></br></br>");
            out.println("Name: <b>"+rs.getString(2)+"</b></br></br>");
            out.println("Phone : <b>"+rs.getInt(3)+"</b></br></br>");
            out.println("Age : <b>"+rs.getInt(4)+"</b></br></br>");
            out.println("Email : <b>"+rs.getString(5)+"</b></br></br>");
        }
        else{
            out.println("<b>No Data Found</b>");
        }
        out.println("</body></html>");
    }
        catch(Exception ex){
            out.println(ex);
        }
    }
}