package com.lcha.Servlet;

import com.lcha.dao.Insert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String love = request.getParameter("love");
        if (love != null) {
            long l = Long.parseLong(System.currentTimeMillis() + "");
            Date date = new Date();
            date.setTime(l);
            String ip = request.getRemoteHost();
            String StrDate = date.toString();
            String end = love + "--"+ip+"--"+StrDate;

            Insert.insert(end);
        }
        response.sendRedirect("http://8.140.23.224/hi/");
        //response.sendRedirect("http://localhost:8080/r.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
