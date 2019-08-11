package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAmountStatus extends AsynchronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person user = (Person) request.getSession().getAttribute("user");

        int aantalOffline = 0;
        int aantalOnline = 0;
        String aantalStr;
        int aantal = 0;

        for (Person p: user.getFriendList()) {
            if (p.getUserStatus().equals("Offline")) {
                aantalOffline += 1;
            } else {
                aantalOnline += 1;
            }
        }

        aantalStr = Integer.toString(aantalOffline) + Integer.toString(aantalOnline);
        aantal = Integer.parseInt(aantalStr);

        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.getWriter().write(toJSON(aantal));

        return null;
    }
}
