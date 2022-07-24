package com.onlinetest.Servlet;

import com.onlinetest.Service.UserService;
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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login()
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
		String password = request.getParameter("password");
		//System.out.println(username+" "+password);

		UserMsg user = userService.findUserMsg(username, password);


		if (user == null) {
			response.getWriter().write("");
		}
		else {
			request.getSession().setAttribute("accountnumber",user.getAccountnumber());
			request.getSession().setAttribute("password",user.getPassword());
			request.getSession().setAttribute("name",user.getName());
			request.getSession().setAttribute("_class",String.valueOf(user.get_class()));
			response.getWriter().write(user.getType());
			System.out.println(user.getType());
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
