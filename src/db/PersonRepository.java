package db;

import java.util.List;

import domain.Conversation;
import domain.Person;

public interface PersonRepository {

	//Person methodes

	Person get(String userId);

	List<Person> getAll();

	Person getAuthenticatedUser(String email, String password);

	Person getPersonByName(String name);

	void add(Person person);

	void delete(String userId);

	void update(Person person);

	void updateStatus(Person person, String status);

	//Conversation methodes

	List<Conversation> getConversations();

	List<Conversation> getAllConversationsFromOneUser(String user);

	Conversation getSpecificConversationBetweenTwoUsers(String user, String chatBuddy);

	void addConversation(Conversation convo);

	void deleteConversation(Conversation convo);
}