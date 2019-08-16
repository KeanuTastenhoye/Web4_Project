package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOut extends SynchronousRequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person user = (Person) request.getSession().getAttribute("user");
		user.setUserStatus("Offline");
		HttpSession session = request.getSession();
		session.invalidate();
		return "index.jsp";
	}
}
