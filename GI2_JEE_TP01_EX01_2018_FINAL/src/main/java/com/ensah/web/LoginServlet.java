package com.ensah.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensah.bo.Game;
import com.ensah.bo.Message;
import com.ensah.bo.Player;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get connexion data
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		List<Message> messages = new ArrayList<Message>();

		// get game object from the context
		Game game = (Game) getServletContext().getAttribute("game");

		// try to find the user by login
		Player u = game.getUserByLogin(login);

		// if exist a user with the given login
		if (u != null) {

			// check password
			if (u.getPassword().equals(password)) {

				// Authentificated, so put the user data in the session
				request.getSession().setAttribute("user", u);

				// server side redirection to Servlet that initializes and shows the home page
				request.getRequestDispatcher("/private/HomeServlet").forward(request, response);

				return;

			}
			{
				// If incorrect password, add necessary messages in request attribute and
				// redirect to login form
				messages.add(new Message("Erreur de connexion, login ou mot de passe incorrects", Message.WARN));
				request.setAttribute("messages", messages);

				// (server side) redirection to login form
				request.getRequestDispatcher("/pages/public/loginForm.jsp").forward(request, response);

				// end
				return;

			}

		} else {

			// if user not found for the given login, add necessary messages in request
			// attribute and
			// redirect to login form
			messages.add(new Message("Incorrect login or password", Message.WARN));
			request.setAttribute("messages", messages);
			request.getRequestDispatcher("/pages/public/loginForm.jsp").forward(request, response);

			// end
			return;
		}
	}
}
