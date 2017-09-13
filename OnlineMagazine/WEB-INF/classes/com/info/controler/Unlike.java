package com.info.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.model.PostModel;
import com.info.service.PostService;

/**
 * Servlet implementation class Unlike
 */
@WebServlet("/Unlike")
public class Unlike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Unlike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Id=request.getParameter("postid");
		
		int value=0;
		
		ArrayList<PostModel> postDb=PostService.getPost();
		for(PostModel show: postDb)
		{
			String userId=show.getId();
			if(Id.equals(userId))
			{
				value=Integer.parseInt(show.getUnlike());
				value=value+1;
			}
		}
		
		
			
			String option=Integer.toString(value);
			
			
			
			System.out.println("Servlet ,,,,, user id is : "+Id+" value is : "+option);
			
			
			PostService obj=new PostService();
			obj.updateUnLike(Id, option);
		
		
		
		
		
		response.sendRedirect("Welcome");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
