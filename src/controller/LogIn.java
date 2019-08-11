package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Person;
import domain.PersonService;

public class LogIn extends SynchronousRequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errors = new ArrayList<String>();
		
		String username = request.getParameter("username");
		if (username == null || username.isEmpty()) {
			errors.add("No username given");
		}
		
		String password = request.getParameter("password");
		if (password == null || password.isEmpty()) {
			errors.add("No password given");
		}
		
		if (errors.size() == 0) {
			PersonService personService = super.getPersonService();
			Person person = personService.getAuthenticatedUser(username, password);
			if (person != null) {
				createSession(person, request, response);
			} else {
				errors.add("No valid username/password");
			}
		}
		
		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
		}

		request.getRequestDispatcher("Controller?action=Index").forward(request, response);
		return "index.jsp";
	}
	
	private void createSession(Person person, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		person.setUserStatus("Online");
		session.setAttribute("user", person);
	}

}
