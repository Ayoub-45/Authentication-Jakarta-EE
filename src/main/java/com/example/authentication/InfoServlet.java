package com.example.authentication;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Date;

public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        response.setContentType("text/html");
        try (var out = response.getWriter()) {
            if (session == null || session.getAttribute("login") == null) {
                out.println("<h1>You must log in to view this information.</h1>");
                out.println("<a href='index.jsp'>Go back to Index</a>");
            } else {
                String login = (String) session.getAttribute("login");
                long creationTime = session.getCreationTime();
                long lastAccessedTime = session.getLastAccessedTime();
                long elapsedTime = (System.currentTimeMillis() - creationTime) / 1000;

                out.println("<h1>Session Information</h1>");
                out.println("<p>Login: " + login + "</p>");
                out.println("<p>Session ID: " + session.getId() + "</p>");
                out.println("<p>Creation Time: " + new Date(creationTime) + "</p>");
                out.println("<p>Last Accessed Time: " + new Date(lastAccessedTime) + "</p>");
                out.println("<p>Elapsed Time: " + elapsedTime + " seconds</p>");
                out.println("<a href='LogoutServlet'>Logout</a>");
            }
        }
    }
}
