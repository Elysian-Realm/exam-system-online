package com.onlinetest.Servlet;

import com.onlinetest.Service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateInfo")
public class UpdateInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        UserService userService = (UserService) ctx.getBean("userService");
        resp.setContentType("text/html;charset=UTF-8");

        String accountnumber = req.getParameter("accountnumber");
        String name = req.getParameter("name");
        int _class = Integer.parseInt(req.getParameter("_class"));

        req.getSession().setAttribute("accountnumber",accountnumber);
        req.getSession().setAttribute("name",name);
        req.getSession().setAttribute("_class",String.valueOf(_class));

        if(userService.updateMsg(accountnumber,name,_class)!=0)resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
