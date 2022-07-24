package com.ITheima;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyHttpServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;

        String mathed=request.getMethod();

        if("Get".equals(mathed))
        {
            doGet();
        }else if("Post".equals(mathed))
        {
            doPost();
        }
    }

    protected void doPost() {
    }

    protected void doGet() {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
