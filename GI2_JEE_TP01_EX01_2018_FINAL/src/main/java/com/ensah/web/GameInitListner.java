package com.ensah.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ensah.bo.Game;
import com.ensah.bo.Player;

/**
 * This class defines a listner that will be executed on context initialization
 * It initializes the data necessary to the game, when the application is
 * starting 
 * 
 * @author boudaa
 *
 */

@WebListener
public class GameInitListner implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {

		// create players
		Player user1 = new Player(Long.valueOf(1), "BOUDAA", "joueur1", "test");
		Player user2 = new Player(Long.valueOf(2), "Alami", "joueur2", "test");

		// Create the game
		Game game = new Game();

		// register users in this game
		game.addUser(user1);
		game.addUser(user2);

		// Store the game object in the app context
		sce.getServletContext().setAttribute("game", game);
		
		

		// just a message in the console for debug purposes
		System.out.println("Les données sont insérée dans le context");

	}

	public void contextDestroyed(ServletContextEvent sce) {
		// just a message in the console for debug purposes
		System.out.println("... Bye bye , Application destroyed");
	}

}
