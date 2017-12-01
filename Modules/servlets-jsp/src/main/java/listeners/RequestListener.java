package listeners;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebListener("LoginListener")
public class RequestListener implements ServletRequestListener {


    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        System.out.println("User left from: " + request.getRequestURI());

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        if (request.getRequestURI().endsWith("/login.html")) {
            System.out.println("Enter to login.html");

        } else if (request.getRequestURI().endsWith("/profile.jsp")) {
            System.out.println("User in system");
            HttpSession session = request.getSession(false);
            String param = (String) session.getAttribute("userInfo");
            System.out.println("User INFO: " + param);
        }
    }
}
