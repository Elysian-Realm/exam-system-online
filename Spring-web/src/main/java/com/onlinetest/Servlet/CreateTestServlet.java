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
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(value = "/CreateTestServlet")

public class CreateTestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        subjectService service = (subjectService) ctx.getBean("subjectService");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String[] str = request.getParameterValues("major");
        for (String s:str){
            System.out.println(s);
        }

        List<Subject> subject = service.MakeTestbytype(str[0],"单选题", 3);
        List<Subject> subject1 = service.MakeTestbytype(str[1],"单选题", 3);
        List<Subject> subject2 = service.MakeTestbytype(str[0],"多选题", 2);
        List<Subject> subject3 = service.MakeTestbytype(str[1],"多选题", 2);
        List<Subject> subject4= service.MakeTestbytype(str[0],"判断题", 2);
        List<Subject> subject5 = service.MakeTestbytype(str[1],"判断题", 2);

        subject.addAll(subject1);
        subject.addAll(subject2);
        subject.addAll(subject3);
        subject.addAll(subject4);
        subject.addAll(subject5);

//        List<Subject> subject = service.MakeTestbytype(str[0],"选择题", 3);
//        List<Subject> subject1 = service.MakeTestbytype(str[1],"选择题", 3);
//        subject.addAll(subject1);
//        System.out.println(subject);

        request.setAttribute("subjects", subject);
        request.getRequestDispatcher("/page/stu_test.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}