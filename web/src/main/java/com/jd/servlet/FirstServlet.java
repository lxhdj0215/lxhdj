package com.jd.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by wangguijun1 on 2018/4/2.
 */
@WebServlet(name = "firstServlet", urlPatterns = "/firstServlet")
public class FirstServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String userName = (String) session.getAttribute("userName");
        if ("wgj".equals(userName)) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

}
