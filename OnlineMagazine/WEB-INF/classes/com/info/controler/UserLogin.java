package com.info.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.info.service.AdminService;
import com.info.service.ConnectionProvider;
import com.info.service.UserService;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String userId=null;
		String name=null;
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
				userId=rs.getString(4);
				name=rs.getString(10);
			}
			System.out.println("validation Succesfully");
		}
		catch(Exception e)
		{
			System.out.println("Validation faild---"+e);
		}
		session.setAttribute("userid", userId);
		session.setAttribute("username", name);
		
		if (flag) {
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeUser");
			rd.forward(request, response);
			
			
		}
		else
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("userLogin.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
