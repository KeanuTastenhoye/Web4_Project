package controller;

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
        List<Person> all = new ArrayList<>();

        if (user != null) {
            all = getPersonService().getPersons();
            List<Person> friends = user.getFriendList();

            for (Person p: all) {
                for (Person f: friends) {
                    if (p.getUserId().equals(f.getUserId())) {
                        if (!p.getUserStatus().equals(f.getUserStatus())) {
                            f.setUserStatus(p.getUserStatus());
                        }
                    }
                }
            }
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
