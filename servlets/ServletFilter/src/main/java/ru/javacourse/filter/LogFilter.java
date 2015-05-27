package ru.javacourse.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Georgy Gobozov on 5/28/2015.
 */
@WebFilter(urlPatterns = "/*")
public class LogFilter implements Filter{



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        System.out.println("======================================");
        System.out.println("Visit time" + new Date() );
        System.out.println("Client address: " + request.getRemoteAddr());
        System.out.println("Client request ulr: " + httpServletRequest.getRequestURL().toString());
        System.out.println("Client agent: " + httpServletRequest.getHeader("User-Agent"));
        System.out.println("Client came from: " + httpServletRequest.getHeader("referer"));
        System.out.println("======================================");


        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
