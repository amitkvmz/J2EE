package com.info.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.info.model.ModeratorModel;
import com.info.model.userModel;

public class UserService 
{
	public static boolean  loginValidation(String username , String password)
	{
		boolean flag=false;	
		String query="select * from user where username=? and password=?";
		try
		{
			Connection con= ConnectionProvider.getConnection();
			PreparedStatement ps =con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				flag=true;
			}
			System.out.println("validation Succesfully");
		}
		catch(Exception e)
		{
			System.out.println("Validation faild---"+e);
		}
		
		return flag;		
	}
	
	public static boolean  insertUser(String username , String password ,String name,String id)
	{
		boolean flag=false;	
		try
		{
			Connection con= ConnectionProvider.getConnection();
			PreparedStatement ps =con.prepareStatement("insert into user values(?,?, ?, ?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, id);
			ps.setString(5, "of");
			int num = ps.executeUpdate();
			if(num>0)
			{
				flag = true;
			}
			System.out.println("inserting Succesfully....");
		}
		catch(Exception e)
		{
			System.out.println("Validation faild---"+e);
		}
		
		return flag;		
	}
	
	
	
	public static ArrayList<userModel> getUser()
	{
		ArrayList<userModel> smsTypeDB = new ArrayList<userModel>();
		
		try
		{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user");			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())	
			{
				String username=rs.getString(1);
				String password=rs.getString(2);
				String name=rs.getString(3);
				String id=rs.getString(4);
				String status=rs.getString(5);
				
				
				userModel obj=new userModel(username, password, name, id,status);	
				smsTypeDB.add(obj);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception while fetchingitem : "+e);
		}		
		return smsTypeDB;
	}
	
	public static boolean remove( String Id)
	{
		boolean flag = false;
		System.out.println("***"+Id);
		
		try
		{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from user where id=?");
			ps.setString(1, Id);
			int rs = ps.executeUpdate();
			System.out.println("DELET SUCCESS");
			if(rs>0)
			{
				flag = true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception while dleting item type : "+e);
		}
		
		return flag;
	}
}
