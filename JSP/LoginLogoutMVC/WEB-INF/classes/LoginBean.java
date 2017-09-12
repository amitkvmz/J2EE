package bean;
import java.sql.*;
public class LoginBean implements java.io.Serializable
{
    public LoginBean()
    {

    }
    private int user;
    private String pass;
    private ResultSet rs;
    public int getUser()
    {
        return user;
    }
    public void setUser(int user)
    {
        this.user=user;
    }
    public String getPass()
    {
        return pass;
    }
    public void setPass(String pass)
    {
        this.pass=pass;
    }
    public ResultSet getRs()
    {
        return rs;
    }
    //ResultSet is a DataType?
    public void setRs(ResultSet r)
    {
        rs=r;
    }

    public boolean execute()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","amit","amit");
            Statement st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM user_info WHERE userid="+user+" AND pass='"+pass+"'");
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception ex)
        {
            return false;
        }
    }
}