package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChangeStatus extends AsynchronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PersonService model = new PersonService();
        Person user = (Person) request.getSession().getAttribute("user");

        if (request.getParameter("username") != null) {
            String newStatus = request.getParameter("newStatus");
            model.getPerson(request.getParameter("username")).setUserStatus(newStatus);
            model.updatePersons(model.getPerson(request.getParameter("username")));
        } else {
            Person person = (Person) request.getSession().getAttribute("user");
            String newStatus = request.getParameter("newStatus");
            model.getPerson(person.getUserId()).setUserStatus(newStatus);
            model.updateStatusPerson(person, newStatus);
        }
        return "chat.jsp";
    }
}
