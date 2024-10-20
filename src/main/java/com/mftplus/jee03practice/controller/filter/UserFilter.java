package com.mftplus.jee03practice.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/user")

public class UserFilter implements Filter {
    public UserFilter() {
        System.out.println("UserFilter constructor");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("User Filter doFilter->");

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getSession().getAttribute("username") != null) {
            System.out.println("User Filter Passed+");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("User Filter reDirect Login->");
            ((HttpServletResponse) servletResponse).sendRedirect("login.do");
        }
    }
}

