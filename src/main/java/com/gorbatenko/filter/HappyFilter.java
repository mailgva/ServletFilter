package com.gorbatenko.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class HappyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("Filter 'happy' happened");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (req.getHeader("x-happy") == null) {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.setContentType("application/json");
            /*
            // Tomcat no longer send user error message
            httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Required headers not specified in the request. You need set header 'x-happy'!");
             */
            httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
