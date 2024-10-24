package com.mftplus.jee03practice.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/admin" , loadOnStartup = 1)
public class AdminServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("AdminServlet - init +");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AdminServlet - service");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("AdminServlet - doGet +");

    }
    @Override
    public void destroy() {
        System.out.println("AdminServlet destroy -");
    }
}
