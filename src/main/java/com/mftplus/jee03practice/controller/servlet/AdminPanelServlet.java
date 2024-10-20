package com.mftplus.jee03practice.controller.servlet;

import com.mftplus.jee03practice.controller.validation.BeanValidation;
import com.mftplus.jee03practice.model.entity.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/admin/adminPanel.do")

public class AdminPanelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/adminPanel.jsp").forward(req, resp);

        Admin admin = Admin.builder().name("mobina").family("azx").build();
        BeanValidation<Admin> validator = new BeanValidation<>();
        Map<String, String> errors = validator.validate(admin);
    }
}
