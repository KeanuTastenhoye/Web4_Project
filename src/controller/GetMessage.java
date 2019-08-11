package controller;

import domain.Conversation;
import domain.Message;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetMessage extends AsynchronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = (Person) request.getSession().getAttribute("user");
        String user = person.getUserId();
        String chatBuddy = request.getParameter("chatBuddy");

        //De berichten tussen de aangemelde gebruiker en de chatbuddy opvragen
        Conversation convo = getPersonService().getSpecificConversationBetweenTwoUsers(user, chatBuddy);
        //Message messages = convo.getMessages().get(convo.getMessages().size() - 1);
        List<Message> messages = convo.getMessages();

        String msgJSON = toJSON(messages);
        response.setContentType("application/json");
        response.getWriter().write(msgJSON);

        return null;
    }
}
