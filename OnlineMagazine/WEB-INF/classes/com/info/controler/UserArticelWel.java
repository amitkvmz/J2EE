package com.info.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.info.model.ModeratorModel;
import com.info.model.PostModel;
import com.info.model.userModel;
import com.info.service.ModeratorService;
import com.info.service.PostService;
import com.info.service.UserService;

/**
 * Servlet implementation class UserArticelWel
 */
@WebServlet("/UserArticelWel")
public class UserArticelWel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserArticelWel() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		String userid=request.getParameter("userid");
		
		session.setAttribute("userid", userid);
		
		ArrayList<PostModel> postDb=PostService.getPost();
		session.setAttribute("postDb", postDb);
		
		ArrayList<userModel> userDb=UserService.getUser();
		session.setAttribute("userDb", userDb);
		
		
		ArrayList<ModeratorModel> modDb=ModeratorService.getModerator();
		session.setAttribute("modDb", modDb);
		
		RequestDispatcher rd=request.getRequestDispatcher("userArticel.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
