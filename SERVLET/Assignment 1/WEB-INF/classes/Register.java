import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Register extends HttpServlet
	{
		public void service(HttpServletRequest req, HttpServletResponse res)
		{   PrintWriter out = null;
			PreparedStatement insertInfo, searchInfo;
			try
			{	res.setContentType("text/html");
				out=res.getWriter();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","incapp","incapp");
				Statement st = con.createStatement();
				insertInfo = con.prepareStatement("insert into info(name,phone,age,email) values(?,?,?,?)");
				String n= req.getParameter("name");
				String p= req.getParameter("phone");
				String ag= req.getParameter("age");
				int a = Integer.parseInt(ag);
				String e= req.getParameter("email");
				searchInfo = con.prepareStatement("select * from info where email=?");
				searchInfo.setString(1,e);
				ResultSet rs = searchInfo.executeQuery();
				if(rs.next())
					{
						res.sendRedirect("registererror.html");			
						
					}
				else
					{
						insertInfo.setString(1,n);
						insertInfo.setString(2,p);
						insertInfo.setInt(3,a);
						insertInfo.setString(4,e);
						insertInfo.executeUpdate();
						
						res.sendRedirect("registersuccess.html");
					}

				
				con.close();

			}
			catch(Exception ex)
			{
				out.println(ex);
			}
		}
		

	}