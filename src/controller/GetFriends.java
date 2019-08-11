package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetFriends extends AsynchronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person user = (Person) request.getSession().getAttribute("user");
        if (user != null) {
            List<Person> friends = user.getFriendList();
            response.setContentType("application/json");
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
            response.getWriter().write(toJSON(friends));
        } else {
            List<Person> people = getPersonService().getPersons();
            response.setContentType("application/json");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.getWriter().write(toJSON(people));
        }
        return null;
    }
}
