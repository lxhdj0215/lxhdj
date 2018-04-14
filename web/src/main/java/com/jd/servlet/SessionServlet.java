package com.jd.servlet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by wangguijun1 on 2018/4/2.
 */
@WebServlet(name = "sessionServlet", urlPatterns = "/sessionServlet")
public class SessionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
