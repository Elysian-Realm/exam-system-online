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

@WebServlet(value = "/delShitiServlet")
public class delShitiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        subjectService subjectService = (subjectService) ctx.getBean("subjectService");
        int id=Integer.parseInt(req.getParameter("id"));
//        System.out.println(id);
        int rows=subjectService.deletesubjectbyid(id);
        resp.getWriter().write(rows);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
