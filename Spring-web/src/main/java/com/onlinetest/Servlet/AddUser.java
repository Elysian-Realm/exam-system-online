package com.onlinetest.Servlet;

import com.onlinetest.Service.UserService;
import com.onlinetest.Service.impl.UserServiceImpl;
import com.onlinetest.domainc.UserMsg;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUser()
	{
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String config = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		UserService userService = (UserService) ctx.getBean("userService");
		response.setContentType("text/html;charset=UTF-8");

		String name = request.getParameter("name");
		String _class = request.getParameter("_class");
		String username = request.getParameter("accountnumber");
		String password = request.getParameter("password");
		String type = request.getParameter("type");

		UserMsg user = new UserMsg(0, name, Integer.parseInt(_class), username, password, type);
		int rows=userService.addUserMsg(user);
		if(rows==1)
		{
			response.getWriter().write("success");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
