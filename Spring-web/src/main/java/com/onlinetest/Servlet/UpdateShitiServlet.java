package com.onlinetest.Servlet;

import com.onlinetest.Service.UserService;
import com.onlinetest.Service.subjectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateShitiServlet")
public class UpdateShitiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        subjectService subjectservice = (subjectService) ctx.getBean("subjectService");
        resp.setContentType("text/html;charset=UTF-8");

        int id=Integer.parseInt(req.getParameter("id"));
        String major=req.getParameter("major");
        String stem=req.getParameter("stem");
        String type=req.getParameter("type");
        String answer=req.getParameter("answer");
        int res=subjectservice.changeSubject(id,major,stem,type,answer);
        System.out.println(type + answer);
        if(res==1)
        {
            resp.getWriter().write("success");
        }
        else {
            resp.getWriter().write("not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
