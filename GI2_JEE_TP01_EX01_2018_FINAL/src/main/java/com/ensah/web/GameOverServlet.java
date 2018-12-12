package com.ensah.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensah.bo.GameRound;
import com.ensah.bo.Message;

/**
 * This Servlet execute ncessary actions when the game over
 * 
 * @author boudaa
 *
 */

@WebServlet("/private/GameOverServlet")
public class GameOverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GameOverServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// List to store messages to pass to the View
		List<Message> messageList = new ArrayList<Message>();

		// get the game round from the request attributes
		GameRound currentRound = (GameRound) request.getAttribute("currentround");

		// put necessary view messages in the list
		messageList.add(new Message("Game Over !", Message.INFO));
		messageList.add(new Message("Final Score = " + currentRound.getRoundScore(), Message.INFO));

		// put messages in the request as attribute
		request.setAttribute("messages", messageList);

		// (sever side) redirect to the game page
		getServletContext().getRequestDispatcher("/pages/private/gameOver.jsp").forward(request, response);

		// end
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
