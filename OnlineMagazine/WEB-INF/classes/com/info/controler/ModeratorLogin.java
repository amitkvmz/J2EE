package com.info.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.service.AdminService;
import com.info.service.ModeratorService;

/**
 * Servlet implementation class ModeratorLogin
 */
@WebServlet("/ModeratorLogin")
public class ModeratorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModeratorLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		ModeratorService obj=new ModeratorService();
		boolean flag=obj.loginValidation(username, password);
		
		if (flag) {
			RequestDispatcher rd=request.getRequestDispatcher("WellcomeModerator");
			rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("wellcomeModerator.jsp");
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
