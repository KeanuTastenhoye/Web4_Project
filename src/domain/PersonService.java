package domain;

import java.util.List;

import db.PersonRepository;
import db.PersonRepositoryStub;

public class PersonService {
	private PersonRepository personRepository = new PersonRepositoryStub();

	public PersonService(){}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}

	//Person Methodes
	
	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public boolean getPersonExists(String personId) {
		if(getPerson(personId) == null || personId.isEmpty()) {
			return false;
		}
		return true;
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public Person getAuthenticatedUser(String email, String password) { return getPersonRepository().getAuthenticatedUser(email, password); }

	public List<Person> getFriendsList(String userId)
	{
		return getPerson(userId).getFriendList();
	}

	public Person getPersonByName(String name) { return getPersonRepository().getPersonByName(name); }

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) { getPersonRepository().update(person); }

	public void updateStatusPerson(Person person, String status) { getPersonRepository().updateStatus(person, status); }

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}

	public void addPersonToFriend(String userId, Person newFriend) {
		this.getPerson(userId).addFriend(newFriend);
	}

	//Conversation methodes

	public List<Conversation> getConversations() { return getPersonRepository().getConversations(); }

	public List<Conversation> getAllConversationsFromOneUser(String user) { return getPersonRepository().getAllConversationsFromOneUser(user); }

	public Conversation getSpecificConversationBetweenTwoUsers(String user, String chatBuddy) { return getPersonRepository().getSpecificConversationBetweenTwoUsers(user, chatBuddy); }

	public void addConversation(Conversation convo) { getPersonRepository().addConversation(convo); }

	public void deleteConversation(Conversation convo) { getPersonRepository().deleteConversation(convo); }
}
