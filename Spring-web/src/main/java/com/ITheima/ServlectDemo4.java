package com.ITheima;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@WebServlet("/req4")
public class ServlectDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        for(String key:map.keySet())
        {
            System.out.print(key+":");
            String[] values = map.get(key);
            for(String value:values)
            {
                value=new String(value.getBytes("ISO8859-1"),"UTF-8");
                System.out.print(value);
            }
            System.out.println();
        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter=resp.getWriter();
        printWriter.println("µÇÂ¼");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);
    }
}
