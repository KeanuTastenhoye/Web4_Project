package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Chat extends SynchronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (!(session.getAttribute("user") == null)) {
            request.getRequestDispatcher("chat.jsp").forward(request, response);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
        return "chat.jsp";
    }
}