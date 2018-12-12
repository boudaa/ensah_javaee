package com.ensah.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensah.bo.Game;
import com.ensah.bo.Message;
import com.ensah.bo.Player;

/**
 * This Servlet initializes the home page
 */
@WebServlet("/private/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Message list
		List<Message> messageList = new ArrayList<Message>();

		// get the connected player from the session
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("user");

		// get the data related to the game
		Game game = (Game) getServletContext().getAttribute("game");

		// add welcome message
		messageList
				.add(new Message("Welcome " + player.getNom() + ", Please click the link start to play", Message.INFO));

		// your best score
		messageList.add(new Message(
				"Your best score is :" + player.getNom() + " his sore :" + player.getPlayerBestScore(), Message.INFO));

		// compute best sore
		Player bestPlayer = (Player) game.getPlayerWithBestScore();
		messageList.add(new Message("Player with the best score is :" + bestPlayer.getNom() + " his sore :"
				+ bestPlayer.getPlayerBestScore(), Message.INFO));

		// put messages in the request
		request.setAttribute("messages", messageList);

		// redirect to the game page
		getServletContext().getRequestDispatcher("/pages/private/home.jsp").forward(request, response);

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
