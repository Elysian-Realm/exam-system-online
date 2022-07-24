package com.onlinetest.Servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.onlinetest.Service.UserService;
import com.onlinetest.domainc.UserMsg;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectAllUser
 */
@WebServlet("/SelectAllUser")
public class SelectAllUser extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectAllUser()
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

		List<UserMsg> users = userService.queryalluser();

		Gson gson = new Gson();
		response.getWriter().write("{\"code\": 0,\"msg\": \"\",\"count\": 1000,\"data\":" + gson.toJson(users) + "}");

		/*List<UserMsg> users = new LinkedList<>();
		users.add(new UserMsg(1, "Tom", 1, "01", "123", "学生"));
		users.add(new UserMsg(2, "Peter", 2, "02", "123", "学生"));
		users.add(new UserMsg(3, "Kevin", 3, "03", "123", "学生"));
		Gson gson = new Gson();
		response.getWriter().write("{\"code\": 0,\"msg\": \"\",\"count\": 1000,\"data\":" + gson.toJson(users) + "}");
		System.out.println("{\"code\": 0,\"msg\": \"\",\"count\": 1000,\"data\":" + gson.toJson(users) + "}");*/
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
