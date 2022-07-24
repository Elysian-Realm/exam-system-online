package com.onlinetest.Servlet;

import com.google.gson.Gson;
import com.onlinetest.Service.UserService;
import com.onlinetest.Service.subjectService;
import com.onlinetest.domainc.Subject;
import com.onlinetest.domainc.UserMsg;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showShitiServlet")
public class showShitiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        subjectService subjectservice = (subjectService) ctx.getBean("subjectService");
        resp.setContentType("text/html;charset=UTF-8");
        List<Subject> subjects = subjectservice.selectall();
        Gson gson = new Gson();
        resp.getWriter().write("{\"code\": 0,\"msg\": \"\",\"count\": 1000,\"data\":" + gson.toJson(subjects) + "}");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
