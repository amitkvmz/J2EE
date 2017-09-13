package com.info.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.service.ModeratorService;

/**
 * Servlet implementation class AddModerator
 */
@WebServlet("/AddModerator")
public class AddModerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddModerator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("work....");
		
		String username=request.getParameter("modUsername");
		String password=request.getParameter("modPassword");
		String name=request.getParameter("modName");
		
		ModeratorService obj=new ModeratorService();
		boolean flag=obj.insertMod(username, password, name);
		
		if (flag) {
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeAdmin");
			rd.forward(request, response);
		}
		
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeAdmin");
			rd.forward(request, response);
			System.out.println("error inserting moderator");
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
