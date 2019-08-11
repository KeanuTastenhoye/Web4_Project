package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Conversation;
import domain.Person;

public class PersonRepositoryStub implements PersonRepository {
	private Map<String, Person> persons = new HashMap<String, Person>();
	private List<Conversation> conversations = new ArrayList<>();

	public PersonRepositoryStub () {
		Person administrator = new Person("admin", "t", "ad", "ministrator");
		Person jan = new Person("jan", "t", "jan", "Jjnssens");
		Person an = new Person("an", "t", "an", "cornelissen");
		Person keanu = new Person("keanu", "t", "keanu", "tastenhoye");

		add(administrator);
		add(jan);
		add(an);
		add(keanu);

		administrator.addFriend(an);
		administrator.addFriend(jan);
		administrator.addFriend(keanu);

		jan.addFriend(administrator);
		jan.addFriend(keanu);

		an.addFriend(administrator);

		keanu.addFriend(administrator);
		keanu.addFriend(jan);
	}

	//Person Methodes

	public Person get(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		return persons.get(personId);
	}

	public List<Person> getAll(){
		return new ArrayList<>(persons.values());
	}

	public Person getAuthenticatedUser(String email, String password) {
		Person person = get(email);

		if (person != null && person.isCorrectPassword(password)) {
			return person;
		} else {
			return null;
		}
	}

	@Override
	public Person getPersonByName(String name) {
		Person ret = null;
		for (Person person: persons.values()) {
			if (person.getFirstName().toLowerCase().equals(name.toLowerCase()) ||
					person.getLastName().toLowerCase().equals(name.toLowerCase())) {
				ret = person;
			}
		}
		return ret;
	}

	public void add(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		if (persons.containsKey(person.getUserId())) {
			throw new IllegalArgumentException("User already exists");
		}
		persons.put(person.getUserId(), person);
	}

	public void update(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		persons.put(person.getUserId(), person);
	}

	public void delete(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		persons.remove(personId);
	}

	//Conversation methodes

	public List<Conversation> getConversations() { return conversations; }

	public List<Conversation> getAllConversationsFromOneUser(String user) {
		List<Conversation> convos = new ArrayList<>();
		for (Conversation c: conversations) {
			if (c.getUser().equals(user) || c.getChatBuddy().equals(user)) {
				convos.add(c);
			}
		}
		return convos;
	}

	public Conversation getSpecificConversationBetweenTwoUsers(String user, String chatBuddy) throws IllegalArgumentException {
		for (Conversation c: conversations) {
			if (c.getUser().equals(user) && c.getChatBuddy().equals(chatBuddy) ||
				c.getUser().equals(chatBuddy) && c.getChatBuddy().equals(user)) {
				return c;
			}
		}
/*
		conversations.add(new Conversation(user, chatBuddy));

		for (Conversation c: conversations) {
			if (c.getUser().equals(user) &&
					c.getChatBuddy().equals(chatBuddy) ||
					c.getUser().equals(chatBuddy) &&
							c.getChatBuddy().equals(user)) {
				return c;
			}
		}
*/
		throw new IllegalArgumentException("Er bestaat nog geen conversatie");
	}

	public void addConversation(Conversation convo) { conversations.add(convo); }

	public void deleteConversation(Conversation convo) { conversations.remove(convo); }

}
