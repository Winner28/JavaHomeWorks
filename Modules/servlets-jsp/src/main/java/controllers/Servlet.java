package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/hello")

public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<html>" +
                "<h1>Hello </h1>");


        String name = req.getParameter("cookiename");
        String value = req.getParameter("cookievalue");

        Cookie cookie = new Cookie(name, value);
        resp.addCookie(cookie);

        Cookie [] cookies = req.getCookies();
        if (cookies!=null) {
            for (Cookie cook : cookies)
                out.write( cook.getName() + " " + cook.getValue() + "<br/>");
        } else {
            out.write("No cookies!!!");
        }


        req.getRequestDispatcher("/index.jsp").include(req, resp);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
