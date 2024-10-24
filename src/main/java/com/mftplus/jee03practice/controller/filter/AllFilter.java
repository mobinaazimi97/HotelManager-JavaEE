package com.mftplus.jee03practice.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/admin/*")
public class AllFilter implements Filter {

    public AllFilter() {
        System.out.println("AllFilter constructor+");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(" All filter doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getSession().getAttribute("admin") != null) {
            System.out.println("admin filter passed++");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("filter redirect login");
            ((HttpServletResponse) servletResponse).sendRedirect("/login.do");


        }
    }
}
