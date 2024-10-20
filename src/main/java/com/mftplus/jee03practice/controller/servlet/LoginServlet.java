package com.mftplus.jee03practice.controller.servlet;

import com.mftplus.jee03practice.model.entity.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login.do")

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin = Admin.builder().username("ali").password("ali1213").build();
        Admin admin1 = Admin.builder().username("sara").password("sara1213").build();
        Admin admin2 = Admin.builder().username("reza").password("reza1213").build();

        req.getSession().setAttribute("adminList", List.of(admin,admin1, admin2));
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");
        Admin admin= Admin.builder().username(username).password(password).build();
        System.out.println(admin);

        if (rememberMe != null && rememberMe.equals("on")) {
            Cookie uCookie = new Cookie("username", username);
            Cookie pCookie = new Cookie("password", password);
            resp.addCookie(uCookie);
            resp.addCookie(pCookie);
        }

        HttpSession session = req.getSession();
        session.setAttribute("admin", admin);
        req.getRequestDispatcher("/admin/adminPanel.jsp").forward(req, resp);

    }
}
