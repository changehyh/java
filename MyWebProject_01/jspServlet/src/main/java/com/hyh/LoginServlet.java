package com.hyh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String para_username = request.getParameter("username");
        String para_password = request.getParameter("password");
       // request.getRequestDispatcher("login.isp").forward(request,response);
        if ("arvin".equals(para_username) && "123".equals(para_password)){
            request.getRequestDispatcher("success.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("failure.jsp").forward(request,response);
        }
    }
}
