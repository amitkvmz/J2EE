import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Process_info extends HttpServlet
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
				String i= req.getParameter("id");				
				int id = Integer.parseInt(i);
				searchInfo = con.prepareStatement("select * from info where id=?");
				searchInfo.setInt(1,id);
				ResultSet rs = searchInfo.executeQuery();
				if(rs.next())
					{
						RequestDispatcher rd = req.getRequestDispatcher("su");
						rd.forward(req,res);  	//rd.include(req,res);			
						
					}
				else
					{
						res.sendRedirect("usererror.html");
					}

				
				con.close();

			}
			catch(Exception ex)
			{
				out.println(ex);
			}
		}
		

	}