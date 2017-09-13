package com.info.controler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.info.model.PostModel;

/**
 * Servlet implementation class PostImage
 */
@WebServlet("/PostImage")
public class PostImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();				
		String postId = request.getParameter("postId");	
		
		ByteArrayInputStream photoIn = null;
		 ArrayList<PostModel> postDb = (ArrayList<PostModel>)session.getAttribute("postDb");
      	if(postDb!=null)
      		for(PostModel show : postDb)
          	{ 
      			String postid=show.getId();
			if(postid.equals(postId))
			{
				photoIn = (ByteArrayInputStream) show.getImage();
				break;
			}
		}	
		
		try
		{
			byte[] pack = new byte[4096];
			int c = 0;
			response.reset();  
	        response.setContentType("image/jpeg"); 
			response.addHeader("Content-Disposition","filename=photo.jpg");
			ServletOutputStream sos = response.getOutputStream();
			
			while((c=photoIn.read(pack))!= -1 )  
			{ 
				sos.write(pack, 0, c);  
			}  
	        response.flushBuffer(); 
	        photoIn.close();  						
		}
		catch(Exception e)
		{
			System.out.println("Error while fetching the father photo: "+e);
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
