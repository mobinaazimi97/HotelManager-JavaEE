package com.mftplus.jee03practice.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/users",loadOnStartup=1)

public class UserServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("UserServlet init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UserServlet - service");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UserServlet doGet");
        HttpSession session=req.getSession();
    }

    @Override
    public void destroy() {
        System.out.println("UserServlet destroy");
    }
}
