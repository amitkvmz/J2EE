package com.info.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider 
{
	public static Connection getConnection()
	{
		Connection con=null;
		String classAddress="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:2345/collegemagazine";
		String user="root";
		String password="amit";
		
		try
		{
			Class.forName(classAddress);
			con=DriverManager.getConnection(url,user,password);
		}
		catch(Exception e)
		{
			System.out.println("Error macking connection - "+e);
		}
		
		return con;
		
	}
}
