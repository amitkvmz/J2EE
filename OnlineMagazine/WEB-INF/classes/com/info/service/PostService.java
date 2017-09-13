package com.info.service;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.info.model.ModeratorModel;
import com.info.model.PostModel;

public class PostService 
{
	
	
	public static boolean  insertPost(PostModel model)
	{
		boolean flag=false;	
		try
		{
			Connection con= ConnectionProvider.getConnection();
			PreparedStatement ps =con.prepareStatement("insert into post values(?,?,?,?, ?, ?,?,?,?,?)");
			ps.setString(1, model.getType());
			ps.setString(2, model.getText());
			ps.setBinaryStream(3, model.getImage());
			ps.setString(4, model.getUserid());
			ps.setString(5, model.getId());
			ps.setString(6, model.getStatus());
			ps.setString(7, model.getDate());
			ps.setString(8, model.getLike());
			ps.setString(9, model.getUnlike());
			ps.setString(10, model.getUsername());
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
	
	
	
	public static ArrayList<PostModel> getPost()
	{
		ArrayList<PostModel> postDB = new ArrayList<PostModel>();
		try
		{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from post");			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())	
			{
				String type=rs.getString(1);
				String text=rs.getString(2);
				InputStream image=rs.getBinaryStream(3);
				String userid=rs.getString(4);
				String id=rs.getString(5);
				String status=rs.getString(6);
				String date=rs.getString(7);
				String like=rs.getString(8);
				String unlike=rs.getString(9);
				String username=rs.getString(10);
				PostModel obj=new PostModel(type, image, text, id, userid, status, date, like, unlike,username);
				postDB.add(obj);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception while fetchingitem : "+e);
		}		
		return postDB;
	}
	
	public static boolean remove(String Id)
	{
		boolean flag = false;
		System.out.println("*** "+Id);
		
		try
		{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from post where id=?");
			ps.setString(1, Id);
			int rs = ps.executeUpdate();
			
			if(rs>0)
			{
				flag = true;
				System.out.println("DELET SUCCESS");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception while dleting item type : "+e);
		}
		
		return flag;
	}
	
	public static boolean update(String Id)
	{
		boolean flag = false;
		System.out.println("*** "+Id);
		
		try
		{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("update post set status=? where id=?");
			ps.setString(1, "live");
			ps.setString(2, Id);
			int rs = ps.executeUpdate();
			
			if(rs>0)
			{
				flag = true;
				System.out.println("posted live update SUCCESS");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception while dleting item type : "+e);
		}
		
		return flag;
	}
	
	public static boolean updateL(String Id,String option)
	{
		boolean flag = false;
		System.out.println("*** "+Id);
		System.out.println("service ,,,,   user id is : "+Id+" value is : "+option);
		try
		{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("update post set lik=? where id=?");
			ps.setString(1, option);
			ps.setString(2, Id);
			int rs = ps.executeUpdate();
			
			if(rs>0)
			{
				flag = true;
				System.out.println("update like SUCCESS");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception while update like : "+e);
		}
		
		return flag;
	}
	
	public static boolean updateUnLike(String Id,String option)
	{
		boolean flag = false;
		System.out.println("*** "+Id);
		System.out.println("service ,,,,   user id is : "+Id+" value is : "+option);
		try
		{
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("update post set unlike=? where id=?");
			ps.setString(1, option);
			ps.setString(2, Id);
			int rs = ps.executeUpdate();
			
			if(rs>0)
			{
				flag = true;
				System.out.println("update unlike SUCCESS");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception while update unlike : "+e);
		}
		
		return flag;
	}
}
