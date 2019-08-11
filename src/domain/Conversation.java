package domain;

import java.util.ArrayList;

public class Conversation {
    private String user;
    private String chatBuddy;
    private ArrayList<Message> messages;

    public Conversation(){}

    public Conversation(String user, String chatBuddy) {
        setUser(user);
        setChatBuddy(chatBuddy);
        messages = new ArrayList<>();
    }

    //Getters

    public String getUser()
    {
        return user;
    }

    public String getChatBuddy()
    {
        return chatBuddy;
    }

    public ArrayList<Message> getMessages()
    {
        return messages;
    }

    //Setters

    public void setUser(String user)
    {
        this.user = user;
    }

    public void setChatBuddy(String chatBuddy)
    {
        this.chatBuddy = chatBuddy;
    }

    //Andere Methodes

    public void addMessage(Message message) { messages.add(message); }

    @Override
    public String toString() {
        return "Conversation{" +
                "user='" + user + '\'' +
                ", chatBuddy='" + chatBuddy + '\'' +
                ", messages=" + messages.toString() +
                '}';
    }
}
