package com.gorbatenko.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AnotherFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("Filter 'another' happened");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (req.getHeader("x-another") == null) {
            System.out.println("Header doesn't exists");
        } else {
            System.out.println("Header exists, value: " + req.getHeader("x-another"));
        }

        ((HttpServletResponse) servletResponse).setHeader("x-another", "true-filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}