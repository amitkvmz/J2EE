package com.info.controler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.info.model.PostModel;
import com.info.service.PostService;
import com.otherID.OtherID;

/*
  Servlet implementation class AddPost
 */

@WebServlet("/AddPost")
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPost() {
        super();
        // TODO Auto-generated constructor stub
    }
    private ServletFileUpload uploader = null;

    public void init() throws ServletException
	{		
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");	
		
		PostModel set=new PostModel();
		try 
		{
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			
			while(fileItemsIterator.hasNext())
			{
				FileItem fileItem = fileItemsIterator.next();	
				if(fileItem.isFormField())
                {
                    
                    if(fileItem.getFieldName().equals("articlCat"))
                    {
                    	String type=(fileItem.getString());
                    	set.setType(type);
                    	System.out.println("type is : "+type);
                    }
                    if(fileItem.getFieldName().equals("text"))
                    {
                    	String text=(fileItem.getString());
                    	set.setText(text);
                    }
                }	
				else
				{
				 InputStream image = fileItem.getInputStream();
				 set.setImage(image);    
				}	
				
			}
		} 
		catch (Exception e) 
		{
			out.write("Exception in uploading form feild file."+e);
		}
		
		
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		Date dateobj = new Date();
		String todayDate=date.format(dateobj);
		OtherID idobj=new OtherID();
		String id=idobj.genratedID();
	String userid=(String)session.getAttribute("userid");
	String username=(String)session.getAttribute("username");
	set.setId(id);
	set.setUserid(userid);
	set.setStatus("pending");
	set.setDate(todayDate);
	set.setLike("1");
	set.setUnlike("0");
	set.setUsername(username);
	PostService obj=new PostService();
	boolean flag=obj.insertPost(set);
	if (flag) {
		RequestDispatcher rd=request.getRequestDispatcher("WelcomeUser");
		rd.forward(request, response);
	}
	else
	{
		RequestDispatcher rd=request.getRequestDispatcher("WelcomeUser");
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
