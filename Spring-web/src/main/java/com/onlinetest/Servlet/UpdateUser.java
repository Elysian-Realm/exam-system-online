package com.onlinetest.Servlet;

import com.onlinetest.Service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUser()
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

		String username = request.getParameter("accountnumber");
		String type = request.getParameter("type");
		int res = userService.changeLimit(username, type);
		if(res != 0)
		{
			response.getWriter().write("success");
		}
		else
		{
			response.getWriter().write("no fount");
		}

//		response.getWriter().write("ok");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
