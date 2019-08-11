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
            /*
            for (Person p: model.getFriendsList(user.getUserId())) {
                for (Person pe: p.getFriendList()) {
                    if (pe.getUserId().equals(user.getUserId())) {
                        pe.setUserStatus(newStatus);
                    }
                }
            }
            */
        } else {
            Person person = (Person) request.getSession().getAttribute("user");
            String newStatus = request.getParameter("newStatus");
            model.getPerson(person.getUserId()).setUserStatus(newStatus);
            model.updatePersons(person);
            /*
            System.out.println("Vriendjes: " + model.getFriendsList(user.getUserId()));
            for (Person p: model.getFriendsList(user.getUserId())) {
                System.out.println("Eerste For-loop: " + p.getUserId() + " " + p.getUserStatus());
                for (Person pe: p.getFriendList()) {
                    System.out.println("Tweede For-loop: " + pe.getUserId() + " " + pe.getUserStatus());
                    if (pe.getUserId().equals(user.getUserId())) {
                        System.out.println("Voor de if: " + pe.getUserId() + " " + pe.getUserStatus());
                        pe.setUserStatus(newStatus);
                        System.out.println("Na de if: " + pe.getUserId() + " " + pe.getUserStatus());
                    }
                }
            }
            */
        }
        return "chat.jsp";
    }
}
