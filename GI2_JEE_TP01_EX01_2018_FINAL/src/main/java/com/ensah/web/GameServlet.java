package com.ensah.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensah.bo.GameRound;
import com.ensah.bo.Message;
import com.ensah.bo.Player;

/**
 * Servlet that implements the game process
 * 
 * @author boudaa
 *
 */
@WebServlet("/private/GameServlet")
public class GameServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public GameServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get request parameter
		String action = request.getParameter("action");

		// Message list
		List<Message> messageList = new ArrayList<Message>();

		// get the connected player from the session
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("user");

		// get the current round of the player
		GameRound currentRound = player.getCurrentRound();

		// if no round exist or the user want to create a new round
		if (currentRound == null || "newround".equals(action)) {

			// create new round and associate it to the current player
			currentRound = new GameRound();
			player.setCurrentRound(currentRound);

			// add it also to the list of all rounds of the player
			player.getRounds().add(currentRound);

			messageList.add(new Message("Please click the game button to start", Message.INFO));

			// put messages in the request
			request.setAttribute("messages", messageList);

			// (sever side) redirect to the game page
			getServletContext().getRequestDispatcher("/pages/private/game.jsp").forward(request, response);

			return;
		}

		int result = -1;
		// if game is over

		// if the game is already over
		if (currentRound.isGameOver()) {

			// add attribute to the request
			request.setAttribute("currentround", currentRound);

			// (sever side) redirect to the game over Servlet
			getServletContext().getRequestDispatcher("/private/GameOverServlet").forward(request, response);
		} else {

			// generate a random number between 1 and 6
			result = new Random().nextInt(6) + 1;

			// if current and previous result are equal
			if (currentRound.getPreviousRes() == result) {

				// increase score
				currentRound.increaseScore();

				// put a message in the list
				messageList.add(new Message("Gagné !", Message.INFO));
				messageList.add(new Message("Score = " + currentRound.getRoundScore(), Message.INFO));
				messageList.add(new Message("number of dice throwing = " + currentRound.getCounter(), Message.INFO));

			} else {
				// put a message in the list
				messageList.add(new Message("Ooops non !", Message.INFO));
				messageList.add(new Message("Score = " + currentRound.getRoundScore(), Message.INFO));
				messageList.add(new Message("number of dice throwing = " + currentRound.getCounter(), Message.INFO));

			}
			// put messages in the request
			request.setAttribute("messages", messageList);

			currentRound.setPreviousRes(result);
			currentRound.incrementCounter();

			// if game becomes over
			if (currentRound.getCounter() == GameRound.NUMBER_OF_ATTEMPTS) {

				// chnage the state of game to over
				currentRound.setState(GameRound.GAME_OVER);

				// add attribute to the request
				request.setAttribute("currentround", currentRound);

				// (sever side) redirect to the game over Servlet
				getServletContext().getRequestDispatcher("/private/GameOverServlet").forward(request, response);
			}

			else {

				// (sever side) redirect to the game page
				getServletContext().getRequestDispatcher("/pages/private/game.jsp").forward(request, response);

				return;
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
