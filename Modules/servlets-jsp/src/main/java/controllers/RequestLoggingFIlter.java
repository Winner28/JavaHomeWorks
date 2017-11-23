package controllers;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter("/hello")
public class RequestLoggingFIlter implements javax.servlet.Filter{

    ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext = filterConfig.getServletContext();
        servletContext.log("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletContext.log(servletRequest.getRemoteAddr() +  " " + servletRequest.getCharacterEncoding()
                            + " " + servletRequest.getLocalName() + "\n");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Cookie[]cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            servletContext.log(cookie.getName() + " ---  " + cookie.getValue());
            System.out.println(cookie.getName() + " ---  " + cookie.getValue());
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
