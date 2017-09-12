package bean;
import java.sql.*;
public class LoginBean
{
    private String userid;
    private Statement statement;
    private String password;
        private boolean result;
        private String name;
        public String getUserid()
        {
            return userid;
        }
        public void setUserid(String u)
        {
            public Statement getStatement()
            {
                return statement;
            }
            public void setStatement(Statement s) throws SQLException
            {
                statement = s;
                ResultSet rs=statement.executeQuery("SELECT * FROM login_info WHERE userid= """+userid+""" AND pass = """+password+"");
                if(rs.next())
                {
                    name=rs.getString(3);
                    result=true;
                }
                else
                {
                    name=null;
                    result=false;
                }
            }
            public String getPassword()
            {
                return password;
            }
            public void setPassword(String password)
            {
                this.password= password;
            }
            public boolean getResult()pass{
                return result;
            }
            public String getName()
            {
                return name;
            }
        }
}