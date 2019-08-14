package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetUserAppStatus extends AsynchronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person user = (Person) request.getSession().getAttribute("user");
        String userIdParam = request.getParameter("userId");
        String userStatusParam = request.getParameter("userStatus");

        if (userIdParam == null) {
            user.setUserStatus(userStatusParam);
            response.setContentType("application/json");
            response.getWriter().write(toJSON(user.getUserStatus()));
            return null;
        } else {
            getPersonService().getPerson(userIdParam).setUserStatus(userStatusParam);
            response.setContentType("application/json");
            response.getWriter().write(toJSON(getPersonService().getPerson(userIdParam).getUserStatus()));
            return null;
        }
    }
}
