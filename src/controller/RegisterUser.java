package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class RegisterUser extends SynchronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person angularUser = new Person();
        ArrayList<String> fouten = new ArrayList<>();

        try {
            angularUser.setUserId(request.getParameter("voornaam"));
            angularUser.setFirstName(request.getParameter("voornaam"));
            angularUser.setLastName(request.getParameter("achternaam"));
            angularUser.setPassword(request.getParameter("paswoord"));
        } catch (IllegalArgumentException e) {
            fouten.add(e.getMessage());
        }

        if (!request.getParameter("paswoord").equals(request.getParameter("paswoordHerhaling"))) {
            fouten.add("Fout paswoord");
        }

        if (fouten.size() != 0) {
            request.setAttribute("fouten", fouten);
        } else {
            Person user = new Person(request.getParameter("voornaam"),
                                     request.getParameter("paswoord"),
                                     request.getParameter("voornaam"),
                                     request.getParameter("achternaam"));
            getPersonService().addPerson(user);
        }

        return "index.jsp";
    }
}
