package com.example.authentication;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AuthenticationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ("guest".equals(login) && "horizon2024".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("login", login);
            response.sendRedirect("index.jsp?message=Authentication%20successful!");
        } else {
            request.setAttribute("error", "Invalid login or password.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
