package com.onlinetest.Servlet;



import com.onlinetest.Service.UserService;
import com.onlinetest.Service.subjectService;
import com.onlinetest.domainc.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addShitiServlet")
public class addShitiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        subjectService subjectService = (subjectService) ctx.getBean("subjectService");
        req.setCharacterEncoding("UTF-8");

        String stem=req.getParameter("stem");
        String major=req.getParameter("major");
        String type=req.getParameter("type");
        String answer=req.getParameter("answer");

        Subject subject=new Subject(0,major,stem,type,answer);
        int rows=subjectService.addsubject(subject);
        System.out.println(subject+" "+rows);

        resp.getWriter().write("success");



 /*       IShitiService is=new ShitiServiceImpl();
        Shiti shiti=new Shiti(id,stem,major);
        is.addShiti(shiti);
resp.sendRedirect("findShitiByPageServlet");*/
    }
}
