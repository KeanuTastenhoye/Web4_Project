package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetStatus extends AsynchronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*
        PersonService model = new PersonService();
        if (request.getParameter("username") != null) {
            String userStatusIF = model.getPerson(request.getParameter("username")).getUserStatus();
            String statusJSON = this.toJSON(userStatusIF);
            response.setContentType("application/json");
            response.getWriter().write(statusJSON);
        } else {
            Person person = (Person) request.getSession().getAttribute("user");
            String userStatusELSE = model.getPerson(person.getUserId()).getUserStatus();
            String statusJSON = this.toJSON(userStatusELSE);
            response.setContentType("application/json");
            response.getWriter().write(statusJSON);
        }
        */

        Person person = (Person) request.getSession().getAttribute("user");
        String userStatus = getPersonService().getPerson(person.getUserId()).getUserStatus();
        String statusJSON = toJSON(userStatus);

        response.setContentType("application/json");
        response.getWriter().write(statusJSON);

        return "chat.jsp";
    }

    /*
    public String toJSON(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
    */
}
