package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Index extends SynchronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "index.jsp";
    }
}
