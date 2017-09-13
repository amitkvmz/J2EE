package com.info.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.info.model.SmsModel;

public class SmService 
{
	
		
		public static boolean  insertSms(SmsModel model)
		{
			boolean flag=false;	
			try
			{
				Connection con= ConnectionProvider.getConnection();
				PreparedStatement ps =con.prepareStatement("insert into sms values(?,?, ?, ?)");
				ps.setString(1, model.getSender());
				ps.setString(2, model.getSms());
				ps.setString(3, model.getSmsid());
				ps.setString(4, model.getReciver());
				
				
				
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
		
		
		
		public static ArrayList<SmsModel> getsms()
		{
			ArrayList<SmsModel> smsTypeDB = new ArrayList<SmsModel>();
			
			try
			{
				Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from sms");			
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())	
				{
					String sender=rs.getString(1);
					String sms=rs.getString(2);
					String smsid=rs.getString(3);
					String reciver=rs.getString(4);
					
					
					SmsModel obj=new SmsModel(sender, sms, smsid, reciver);	
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
