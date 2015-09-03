package ru.javacourse.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Georgy Gobozov on 5/28/2015.
 */
public class AuthFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession session = httpServletRequest.getSession(true);

        if (session.getAttribute("token")!= null){

            filterChain.doFilter(request, response);

        }else {
            httpServletResponse.sendRedirect("/login.html");
        }

    }

    @Override
    public void destroy() {

    }
}
