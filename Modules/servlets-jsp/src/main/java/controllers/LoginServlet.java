package controllers;

import helpers.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/pages/LoginServlet")
public class LoginServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");



        String userName = req.getParameter("login");
        String passWord = req.getParameter("password");

        if (Users.hasUser(userName) && Users.matchPassword(userName, passWord)) {
            System.out.println("You are in system");
            HttpSession session = req.getSession();
            session.setAttribute("userInfo", "Name: " +userName +  " Pass: "+ passWord);
            session.setMaxInactiveInterval(30);
            Cookie user = new Cookie("userName", userName);
            user.setMaxAge(30);
            resp.addCookie(user);
            resp.sendRedirect("/pages/profile.jsp");
        } else {
            PrintWriter out = resp.getWriter();
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/login.html");
            out.println("<font color=red>Either user name or password is wrong.</font>");
            requestDispatcher.include(req, resp);
        }

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
