package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddFriend extends AsynchronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person user = (Person) request.getSession().getAttribute("user");
        String newFriendID = request.getParameter("newFriendID");

        for (Person p: getPersonService().getPersons()) {
            if (p.getUserId().equals(newFriendID)) {
                getPersonService().addPersonToFriend(user.getUserId(), p);
                getPersonService().addPersonToFriend(newFriendID, user);
                return null;
            }
        }
        Person friend = new Person(newFriendID, "t", newFriendID, "Stevens");

        getPersonService().addPerson(friend);
        List<String> friendErrors = new ArrayList<>();

        if (friend == null) {
            friendErrors.add("No friend found");
        } else if (user.getFriendList().contains(friend)) {
            friendErrors.add("This friend already exists in your current friendList");
        } else if (friend.getUserId().equals(user.getUserId())) {
            friendErrors.add("You can't add yourself as a friend");
        }

        if (friendErrors.size()> 0) {
            request.setAttribute("friendErrors", friendErrors);
        } else {
            user.addFriend(friend);
            friend.addFriend(user);
        }
        return null;
    }
}
