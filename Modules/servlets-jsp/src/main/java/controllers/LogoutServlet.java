package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/pages/LogOut")
public class LogoutServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Cookie []cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userName")) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                break;
            }
        }

        HttpSession session = req.getSession(false);
        if (session!=null) {
            System.out.println("Session invalidate for user: " + session.getAttribute("userInfo"));
            session.setMaxInactiveInterval(0);
            session.invalidate();
        }

        resp.sendRedirect("/");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
