package com.gorbatenko.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/")
@Configuration
public class GorbatenkoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter 'gorbatenko' happened");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (req.getHeader("x-gorbatenko") == null) {
            System.out.println("Header doesn't exists");
        } else {
            System.out.println("Header exists, value: " + req.getHeader("x-gorbatenko"));
        }

        ((HttpServletResponse) servletResponse).setHeader("x-gorbatenko", "true-filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}