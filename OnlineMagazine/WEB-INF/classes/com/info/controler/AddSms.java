package com.info.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.info.model.SmsModel;
import com.info.service.SmService;
import com.otherID.OtherID;

/**
 * Servlet implementation class AddSms
 */
@WebServlet("/AddSms")
public class AddSms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSms() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String sender=(String)session.getAttribute("userid");
		
		
		System.out.println("sender id : "+sender);
		
		OtherID idobj=new OtherID();
		String smsid=idobj.genratedID();
		
		String reciver=request.getParameter("userid");
		String sms=request.getParameter("sms");
		
		SmService obj =new SmService();
		SmsModel model=new SmsModel(sender, sms, smsid, reciver);
		boolean flag=obj.insertSms(model);
		
		if (flag) {
			RequestDispatcher rd=request.getRequestDispatcher("ForwardChatPage");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ForwardChatPage");
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
