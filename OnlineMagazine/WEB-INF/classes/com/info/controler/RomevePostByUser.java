package com.info.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.service.ModeratorService;
import com.info.service.PostService;

/**
 * Servlet implementation class RomevePostByUser
 */
@WebServlet("/RomevePostByUser")
public class RomevePostByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RomevePostByUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("ID");
		
		PostService obj=new PostService();
		boolean flag=obj.remove(id);
		if (flag) {
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeUser");
			rd.forward(request, response);
		}
		
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeUser");
			rd.forward(request, response);
			System.out.println("erroe deleting post");
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
