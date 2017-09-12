import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Show_info extends HttpServlet
	{
		public void service(HttpServletRequest req, HttpServletResponse res)
		{   PrintWriter out = null;
			PreparedStatement insertInfo;
			try
			{	res.setContentType("text/html");
				out=res.getWriter();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","incapp","incapp");
				Statement st = con.createStatement();
				
				String i= req.getParameter("id");
				
				int id = Integer.parseInt(i);
				
				
				ResultSet rs = st.executeQuery("select * from info where id =" +id);
				while(rs.next())
				{
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					int age = rs.getInt("age");
					String email = rs.getString("email");
					out.println("<html><body><div style='height=100px; background-color:black; color:white;'><h1><center>"+
						"Welcome to User Information</center></h1></div><center><table border=1 style='border:1px solid black; border-radius:8px;'>"+
						"<tr><td>Name</td><td>"+ name+"</td></tr> <tr style='background-color:#4cae4c;'><td>Phone</td><td>"+phone+"</td></tr> <tr><td>Age</td><td>"+age+
						"</td></tr> <tr style='background-color:#4cae4c;'><td>Email</td><td>" +email+"</td></tr></table></center>");
					
					
				}
				
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