package com.mftplus.jee03practice.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(urlPatterns = "/admin")

public class AdminFilter implements Filter {

    public AdminFilter() {
        System.out.println("Admin Filter Constructor");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Admin Filter doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        servletRequest.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
      //  ((HttpServletRequest)servletRequest).getSession().getAttribute("user");

    }
}
