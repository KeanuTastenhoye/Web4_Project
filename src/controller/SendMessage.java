package controller;

import domain.Conversation;
import domain.Message;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendMessage extends AsynchronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = (Person) request.getSession().getAttribute("user");
        String user = person.getUserId();
        String chatBuddy = request.getParameter("userId");
        String chatMessage = request.getParameter("chatMessage");

        //Kijken of er een convo is tussen user en chatbuddy, ZoJa bericht toevoegen
        try {
            getPersonService().getSpecificConversationBetweenTwoUsers(user, chatBuddy).addMessage(new Message(user, chatMessage));
        } catch (IllegalArgumentException e) {
        //ZoNiet convo aanmaken en vervolgens toevoegen
            getPersonService().addConversation(new Conversation(user, chatBuddy));
            getPersonService().getSpecificConversationBetweenTwoUsers(user, chatBuddy).addMessage(new Message(user, chatMessage));
        }
        System.out.println(getPersonService().getSpecificConversationBetweenTwoUsers(user, chatBuddy));
        return null;
    }
}