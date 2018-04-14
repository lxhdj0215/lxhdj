package com.jd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wangguijun1 on 2018/4/2.
 */
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getRequestedSessionId());
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("userName".equals(name)) {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                }
            }
        }
        String userName = (String) request.getParameter("userName");
        String userPwd = (String) request.getParameter("userPwd");
        if ("wgj".equals(userName) && "123456".equals(userPwd)) {
            Cookie cookie = new Cookie("userName", userName);
            response.addCookie(cookie);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
